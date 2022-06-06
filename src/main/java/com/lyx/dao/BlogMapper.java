package com.lyx.dao;

import com.lyx.bean.Blog;
import com.lyx.bean.BlogAndTag;
import com.lyx.bean.dto.BlogByOrder;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogMapper
 * @description: TODO
 * @date 2022/5/15 15:53
 */
@Mapper
public interface BlogMapper {
    Integer getBlogCount();

    Integer getBlogSumViews();

    Integer getBlogCommentCount();

    Blog getBlog(Integer id);

    Blog getBlogByTitle(String title);

    List<Blog> listBlogByPage();

    List<Blog> listBlogByTypeId(Integer typeId);

    List<Blog> listBlogByTagId(Integer tagId);

    List<String> listBlogCreateDate();

    List<Blog> listBlogByCreateDate(String year);

    List<Blog> listBlogByFrontPage();

    List<Blog> listBlogBySearch(String condition);

    List<BlogByOrder> listBlogByOrder(Integer limit);

    List<BlogByOrder> listBlogAllByOrder();

    List<Blog> listBlog();

    int saveBlog(Blog blog);

    int saveBlogAndTag(BlogAndTag bt);

    int updateBlog(Blog blog);

    int updateBlogAndTag(BlogAndTag bt);

    int updateBlogViews(Integer id);

    int deleteBlog(Integer id);

    int deleteBlogAndTag(Integer id);

    int deleteBlogAndTagByIds(Integer id, String ids);
}
