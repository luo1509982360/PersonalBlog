package com.lyx.dao;

import com.lyx.bean.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: CommentMapper
 * @description: TODO
 * @date 2022/5/21 13:23
 */
@Mapper
public interface CommentMapper {
    Comment getCommentByParentCommentId(Integer parentCommentId);

    List<Comment> listCommentByBlogId(Integer blogId);

    List<Comment> listCommentAllByBlogId();

    List<Comment> listComment();

    //添加一个评论
    int saveComment(Comment comment);

    int deleteCommentByBlogId(Integer blogId);

    int deleteCommentById(Integer id);
}
