package com.lyx.service.impl;

import com.lyx.bean.Blog;
import com.lyx.bean.BlogAndTag;
import com.lyx.bean.dto.BlogByOrder;
import com.lyx.dao.BlogMapper;
import com.lyx.dao.CommentMapper;
import com.lyx.service.BlogService;
import com.lyx.util.MarkdownUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogServiceImpl
 * @description: TODO
 * @date 2022/5/15 15:55
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;

    @Autowired
    CommentMapper commentMapper;

    @Override
    public Integer getBlogCount() {
        return blogMapper.getBlogCount();
    }

    @Override
    public Integer getBlogSumViews() {
        return blogMapper.getBlogSumViews();
    }

    @Override
    public Integer getBlogCommentCount() {
        return blogMapper.getBlogCommentCount();
    }

    @Override
    public Blog getBlog(Integer id) {
        Blog blog = blogMapper.getBlog(id);

        return blog;
    }

    @Override
    public Blog getBlogAndConvert(Integer id) {
        Blog blog = blogMapper.getBlog(id);

        Blog newBlog = new Blog();
        BeanUtils.copyProperties(blog, newBlog);

        String content = newBlog.getContent();
        newBlog.setContent(MarkdownUtils.markdownToHtmlExtensions(content));

        return newBlog;
    }

    @Override
    public Blog getBlogByTitle(String title) {
        Blog blog = blogMapper.getBlogByTitle(title);

        return blog;
    }

    @Override
    public List<Blog> listBlog() {
        List<Blog> blogs = blogMapper.listBlog();

        return blogs;
    }

    @Override
    public List<Blog> listBlogByPage() {
        List<Blog> blogs = blogMapper.listBlogByPage();

        return blogs;
    }

    @Override
    public List<Blog> listBlogByFrontPage() {
        List<Blog> blogs = blogMapper.listBlogByFrontPage();

        return blogs;
    }

    @Override
    public List<Blog> listBlogBySearch(String condition) {
        List<Blog> blogs = blogMapper.listBlogBySearch(condition);

        return blogs;
    }

    @Override
    public List<BlogByOrder> listBlogByOrder(Integer limit) {
        List<BlogByOrder> blogs = blogMapper.listBlogByOrder(limit);

        return blogs;
    }

    @Override
    public List<BlogByOrder> listBlogAllByOrder() {
        List<BlogByOrder> blogs = blogMapper.listBlogAllByOrder();

        return blogs;
    }

    @Override
    public List<Blog> listBlogByTypeId(Integer typeId) {
        List<Blog> blogs = blogMapper.listBlogByTypeId(typeId);

        return blogs;
    }

    @Override
    public List<Blog> listBlogByTagId(Integer tagId) {
        List<Blog> blogs = blogMapper.listBlogByTagId(tagId);

        return blogs;
    }

    @Override
    public Map<String, List<Blog>> archivesBlog() {
        List<String> years = blogMapper.listBlogCreateDate();
        Map<String, List<Blog>> map = new HashMap<>();
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");

        for (String year : years) {
            List<Blog> blogs = blogMapper.listBlogByCreateDate(year);
            for (int i = 0; i < blogs.size(); i++) {
                blogs.get(i).setCreateDateStr(sdf.format(blogs.get(i).getCreateDate()));
            }
            map.put(year, blogs);
        }

        return map;
    }

    @Transactional
    @Override
    public int saveBlog(Blog blog) {
        blog.setCreateDate(new Date());
        blog.setUpdateDate(new Date());
        blog.setViews(0);

        int count = blogMapper.saveBlog(blog);
        Blog blogByTitle = blogMapper.getBlogByTitle(blog.getTitle());
        for (int i = 0; i < blog.getTags().size(); i++) {
            BlogAndTag bt = new BlogAndTag(blogByTitle.getId(), blog.getTags().get(i).getId());
            blogMapper.saveBlogAndTag(bt);
        }

        return count;
    }

    @Transactional
    @Override
    public int updateBlog(Blog blog) {
        blog.setUpdateDate(new Date());
        int count = blogMapper.updateBlog(blog);

        blogMapper.deleteBlogAndTagByIds(blog.getId(), blog.getOldTagIds());
        String[] strs = blog.getTagIds().split("\\,");
        for (int i = 0; i < strs.length; i++) {
            blogMapper.saveBlogAndTag(new BlogAndTag(blog.getId(), Integer.valueOf(strs[i])));
        }

        return count;
    }

    @Transactional
    @Override
    public int blogViewsPlusOne(Integer id) {
        return blogMapper.updateBlogViews(id);
    }

    @Transactional
    @Override
    public int deleteBlog(Integer id) {
        int count = blogMapper.deleteBlog(id);
        blogMapper.deleteBlogAndTag(id);
        commentMapper.deleteCommentByBlogId(id);

        return count;
    }
}
