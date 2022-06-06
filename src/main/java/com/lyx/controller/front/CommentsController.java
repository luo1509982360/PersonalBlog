package com.lyx.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.Comment;
import com.lyx.service.BlogService;
import com.lyx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: CommentController
 * @description: TODO
 * @date 2022/5/21 13:21
 */
@Controller
public class CommentsController {
    @Autowired
    CommentService commentService;

    @Autowired
    BlogService blogService;

    @Value("${comment.avatar}")
    private String avatar;

    @GetMapping("/comments")
    public String comments(@RequestParam Integer id, Model model) {
        List<Comment> comments = commentService.listCommentByblogId(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < comments.size(); i++) {
            comments.get(i).setCreateDateStr(sdf.format(comments.get(i).getCreateDate()));
        }

        model.addAttribute("comments", comments);

        return "front/blog :: commentList";
    }

    @PostMapping("/saveComment")
    public String saveComment(Comment comment) {
        System.out.println("************" + comment);
        if (comment.getBlog().getId() != -1) {
            comment.setAvatar(avatar);
            int count = commentService.saveComment(comment);

            return "redirect:/comments/?id=" + comment.getBlog().getId();
        } else {
            comment.setAvatar(avatar);
            int count = commentService.saveComment(comment);

            return "redirect:/showComments";
        }
    }

    @GetMapping("/showComments")
    public String showCommentsPage(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 7);

        List<Comment> comments = commentService.listCommentAllByblogId();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < comments.size(); i++) {
            comments.get(i).setCreateDateStr(sdf.format(comments.get(i).getCreateDate()));
        }

        PageInfo pageInfo = new PageInfo(comments, 5);
        System.out.println(pageInfo);

        model.addAttribute("page", pageInfo);

        model.addAttribute("newBlogs", blogService.listBlogByOrder(3));
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());

        return "front/comments";
    }

}
