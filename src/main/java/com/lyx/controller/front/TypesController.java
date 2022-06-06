package com.lyx.controller.front;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.Blog;
import com.lyx.bean.dto.BlogByOrder;
import com.lyx.bean.dto.TypeByGroupAndOrder;
import com.lyx.service.BlogService;
import com.lyx.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TypesController
 * @description: TODO
 * @date 2022/5/21 18:32
 */
@Controller
public class TypesController {
    @Autowired
    TypeService typeService;

    @Autowired
    BlogService blogService;

    @GetMapping("/showTypes")
    public String showTypes(@RequestParam(value = "id", defaultValue = "-1") Integer id, @RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        List<TypeByGroupAndOrder> types = typeService.listAllTypeByGroupAndOrder();
        System.out.println(types);
        if (id == -1) {
            id = types.get(0).getId();
        }
        List<Blog> blogs = blogService.listBlogByTypeId(id);
        PageHelper.startPage(pn, 5);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (int i = 0; i < blogs.size(); i++) {
            blogs.get(i).setUpdateDateStr(sdf.format(blogs.get(i).getUpdateDate()));
        }

        PageInfo pageInfo = new PageInfo(blogs, 5);

        model.addAttribute("types", types);
        model.addAttribute("page", pageInfo);
        model.addAttribute("activeTypeId", id);

        List<BlogByOrder> blogByOrders = blogService.listBlogAllByOrder();
        List<BlogByOrder> newBlogs = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            newBlogs.add(blogByOrders.get(i));
        }
        model.addAttribute("newBlogs", newBlogs);
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());

        return "front/types";
    }
}
