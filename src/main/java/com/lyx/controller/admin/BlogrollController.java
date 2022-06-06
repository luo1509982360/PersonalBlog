package com.lyx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.Blogroll;
import com.lyx.bean.Type;
import com.lyx.service.BlogService;
import com.lyx.service.BlogrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: Blogroll
 * @description: TODO
 * @date 2022/5/26 14:33
 */
@Controller
@RequestMapping("admin")
public class BlogrollController {
    @Autowired
    BlogrollService blogrollService;

    @RequestMapping("/blogrolls")
    public String showBlogrolls(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Blogroll> blogrolls = blogrollService.listBlogroll();
        PageInfo pageInfo = new PageInfo(blogrolls, 5);

        model.addAttribute("page", pageInfo);

        return "admin/blogrolls";
    }

    @GetMapping("/saveBlogrollPage")
    public String saveBlogrollPage() {

        return "admin/blogroll_save";
    }

    @PostMapping("/saveBlogroll")
    public String saveBlogroll(Blogroll blogroll, RedirectAttributes redirectAttributes) {
        int count = blogrollService.saveBlogroll(blogroll);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/blogrolls?pn=999";

    }

    @GetMapping("/updateBlogrollPage")
    public String updateBlogrollPage(@RequestParam Integer id, Model model) {
        Blogroll blogroll = blogrollService.getBlogroll(id);
        model.addAttribute("blogroll", blogroll);

        return "admin/blogroll_update";
    }

    @PostMapping("/updateBlogroll")
    public String updateBlogroll(Blogroll blogroll, RedirectAttributes redirectAttributes) {
        int count = blogrollService.updateBlogroll(blogroll);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/blogrolls";
    }

    @GetMapping("/deleteBlogroll")
    public String deleteBlogroll(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        int count = blogrollService.deleteBlogroll(id);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/blogrolls";
    }
}
