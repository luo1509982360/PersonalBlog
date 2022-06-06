package com.lyx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.Comment;
import com.lyx.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: CommentController
 * @description: TODO
 * @date 2022/5/23 10:25
 */
@Controller
@RequestMapping("admin")
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping("/listComment")
    public String listComment(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model){
        PageHelper.startPage(pn, 5);

        List<Comment> comments = commentService.listAllComment();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int i = 0; i < comments.size(); i++) {
            comments.get(i).setCreateDateStr(sdf.format(comments.get(i).getCreateDate()));
        }

        PageInfo pageInfo = new PageInfo(comments, 5);

        model.addAttribute("page", pageInfo);

        return "admin/comments";
    }

    @GetMapping("/deleteComment")
    public String deleteTag(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        int count = commentService.deleteCommentById(id);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/listComment";
    }
}
