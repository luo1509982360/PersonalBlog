package com.lyx.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.Blog;
import com.lyx.bean.dto.*;
import com.lyx.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: IndexController
 * @description: TODO
 * @date 2022/5/12 15:15
 */
@Controller
public class IndexController {
    @Autowired
    BlogService blogService;

    @Autowired
    TypeService typeService;

    @Autowired
    TagService tagService;

    @GetMapping("/")
    public String index(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 7);

        List<Blog> pageBlogs = blogService.listBlogByFrontPage();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < pageBlogs.size(); i++) {
            pageBlogs.get(i).setUpdateDateStr(sdf.format(pageBlogs.get(i).getUpdateDate()));
        }
        PageInfo pageInfo = new PageInfo(pageBlogs, 5);

        List<TypeByGroupAndOrder> types = typeService.listTypeByGroupAndOrder(5);

        List<TagByGroupAndOrder> tags = tagService.listTagByGroupAndOrder(7);

        List<BlogByOrder> blogs = blogService.listBlogByOrder(3);

        model.addAttribute("page", pageInfo);
        model.addAttribute("blogs", blogs);
        model.addAttribute("types", types);
        model.addAttribute("tags", tags);

        model.addAttribute("newBlogs", blogService.listBlogByOrder(3));
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());

        return "front/index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(value = "pn", defaultValue = "1") Integer pn, String condition, Model model) {
        PageHelper.startPage(pn, 7);

        List<Blog> pageBlogs = blogService.listBlogBySearch(condition);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < pageBlogs.size(); i++) {
            pageBlogs.get(i).setUpdateDateStr(sdf.format(pageBlogs.get(i).getUpdateDate()));
        }

        PageInfo pageInfo = new PageInfo(pageBlogs, 5);
        model.addAttribute("page", pageInfo);
        model.addAttribute("condition", condition);

        model.addAttribute("newBlogs", blogService.listBlogByOrder(3));
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());

        return "front/search";
    }

    @GetMapping("/blog")
    public String blog(@RequestParam Integer id, Model model) {
        blogService.blogViewsPlusOne(id);
        Blog blog = blogService.getBlogAndConvert(id);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        blog.setCreateDateStr(sdf.format(blog.getCreateDate()));
        blog.setUpdateDateStr(sdf.format(blog.getUpdateDate()));

        model.addAttribute("blog", blog);

        model.addAttribute("newBlogs", blogService.listBlogByOrder(3));
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());

        return "front/blog";
    }
}
