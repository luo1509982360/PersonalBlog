package com.lyx.controller.front;

import com.lyx.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author The setting sun
 * @version 1.0
 * @title: AboutMeController
 * @description: TODO
 * @date 2022/5/23 15:00
 */
@Controller
public class AboutMeController {
    @Autowired
    BlogService blogService;

    @GetMapping("/aboutme")
    public String aboutme(Model model){
        model.addAttribute("newBlogs", blogService.listBlogByOrder(3));
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());
        return "front/aboutme";
    }
}
