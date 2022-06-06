package com.lyx.service.impl;

import com.lyx.bean.Comment;
import com.lyx.dao.BlogMapper;
import com.lyx.dao.CommentMapper;
import com.lyx.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: CommentServiceImpl
 * @description: TODO
 * @date 2022/5/21 14:10
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;

    @Override
    public List<Comment> listCommentByblogId(Integer blogId) {
        List<Comment> comments = commentMapper.listCommentByBlogId(blogId);

        return comments;
    }

    @Override
    public List<Comment> listCommentAllByblogId() {
        List<Comment> comments = commentMapper.listCommentAllByBlogId();

        return comments;
    }

    @Override
    public List<Comment> listComment() {
        List<Comment> comments = commentMapper.listComment();

        return comments;
    }

    @Transactional
    @Override
    public int saveComment(Comment comment) {
        Integer parentCommentId = comment.getParentComment().getId();
        if (parentCommentId != -1) {
            comment.setParentComment(commentMapper.getCommentByParentCommentId(parentCommentId));
        } else {
            comment.setParentComment(null);
        }

        comment.setCreateDate(new Date());

        return commentMapper.saveComment(comment);
    }

    @Transactional
    @Override
    public int deleteCommentById(Integer id) {
        return commentMapper.deleteCommentById(id);
    }
}
