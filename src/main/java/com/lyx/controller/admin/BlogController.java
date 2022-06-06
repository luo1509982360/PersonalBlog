package com.lyx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.*;
import com.lyx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: BlogController
 * @description: TODO
 * @date 2022/5/14 15:30
 */
@Controller
@RequestMapping("admin")
public class BlogController {
    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @GetMapping("/blogs")
    public String blogs(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);

        List<Blog> blogs = blogService.listBlogByPage();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (int i = 0; i < blogs.size(); i++) {
            blogs.get(i).setUpdateDateStr(sdf.format(blogs.get(i).getUpdateDate()));
        }

        PageInfo pageInfo = new PageInfo(blogs, 5);
        model.addAttribute("page", pageInfo);

        return "admin/blogs";
    }

    @PostMapping("/saveBlog")
    public String saveBlog(Blog blog, HttpSession session, RedirectAttributes redirectAttributes) {
        blog.setUser((User) session.getAttribute("user"));
        blog.setType(typeService.getType(blog.getType().getId()));
        blog.setTags(tagService.listTagByIds(blog.getTagIds()));

        Blog checkBlog = blogService.getBlogByTitle(blog.getTitle());
        if (checkBlog == null) {
            int count = blogService.saveBlog(blog);
            if (count == 0) {
                redirectAttributes.addFlashAttribute("message", "操作失败");
            } else {
                redirectAttributes.addFlashAttribute("message", "操作成功");
            }

            return "redirect:/admin/blogs?pn=999";
        } else {
            redirectAttributes.addFlashAttribute("message", "博客标题已存在，请重新输入");

            return "redirect:/admin/saveBlogPage";
        }
    }

    @GetMapping("/saveBlogPage")
    public String saveBlogPage(Model model) {
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());

        return "admin/blog_save";
    }

    @GetMapping("/updateBlogPage")
    public String updateBlogPage(@RequestParam Integer id, Model model) {
        Blog blog = blogService.getBlog(id);
        System.out.println(blog);
        blog.initIds();

        model.addAttribute("blog", blog);
        model.addAttribute("types", typeService.listType());
        model.addAttribute("tags", tagService.listTag());

        return "admin/blog_update";
    }

    @PostMapping("/updateBlog")
    public String updateBlog(Blog blog, RedirectAttributes redirectAttributes) {
//        System.out.println(blog);
        int count = blogService.updateBlog(blog);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/blogs";
    }

    @GetMapping("/deleteBlog")
    public String deleteTag(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        int count = blogService.deleteBlog(id);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/blogs";
    }
}
