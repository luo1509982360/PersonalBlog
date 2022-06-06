package com.lyx.controller.front;

import com.lyx.service.BlogService;
import com.lyx.service.BlogrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author The setting sun
 * @version 1.0
 * @title: Blogroll
 * @description: TODO
 * @date 2022/5/26 14:33
 */
@Controller
public class BlogrollsController {
    @Autowired
    BlogService blogService;

    @Autowired
    BlogrollService blogrollService;

    @RequestMapping("/showBlogrolls")
    public String showBlogrolls(Model model) {
        System.out.println(blogService.listBlog());
        model.addAttribute("blogrolls", blogrollService.listBlogroll());
        model.addAttribute("newBlogs", blogService.listBlogByOrder(3));
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());

        return "front/blogrolls";
    }
}
