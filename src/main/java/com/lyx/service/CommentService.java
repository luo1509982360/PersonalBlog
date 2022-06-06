package com.lyx.service;

import com.lyx.bean.Comment;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: CommentService
 * @description: TODO
 * @date 2022/5/21 14:10
 */
@Service
public interface CommentService {
    List<Comment> listCommentByblogId(Integer blogId);

    List<Comment> listCommentAllByblogId();

    List<Comment> listComment();

    int saveComment(Comment comment);

    int deleteCommentById(Integer id);
}
