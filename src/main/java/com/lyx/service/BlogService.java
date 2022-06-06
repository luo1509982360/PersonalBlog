package com.lyx.service;

import com.lyx.bean.Blog;
import com.lyx.bean.dto.BlogByOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogService
 * @description: TODO
 * @date 2022/5/15 15:54
 */
@Service
public interface BlogService {
    Integer getBlogCount();

    Integer getBlogSumViews();

    Integer getBlogCommentCount();

    Blog getBlog(Integer id);

    Blog getBlogAndConvert(Integer id);

    Blog getBlogByTitle(String title);

    List<Blog> listBlog();

    List<Blog> listBlogByPage();

    List<Blog> listBlogByFrontPage();

    List<Blog> listBlogBySearch(String condition);

    List<BlogByOrder> listBlogByOrder(Integer limit);

    List<BlogByOrder> listBlogAllByOrder();

    List<Blog> listBlogByTypeId(Integer typeId);

    List<Blog> listBlogByTagId(Integer tagId);

    Map<String, List<Blog>> archivesBlog();

    int saveBlog(Blog blog);

    int updateBlog(Blog blog);

    int blogViewsPlusOne(Integer id);

    int deleteBlog(Integer id);
}
