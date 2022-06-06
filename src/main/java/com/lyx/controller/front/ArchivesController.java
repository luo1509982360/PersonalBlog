package com.lyx.controller.front;

import com.lyx.bean.Blog;
import com.lyx.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;

/**
 * @author The setting sun
 * @version 1.0
 * @title: ArchivesController
 * @description: TODO
 * @date 2022/5/23 14:16
 */
@Controller
public class ArchivesController {
    @Autowired
    BlogService blogService;

    @RequestMapping("/showArchives")
    public String showArchives(Model model) {
        Map<String, List<Blog>> archivesMap = blogService.archivesBlog();
        Integer blogCount = blogService.getBlogCount();

        model.addAttribute("archivesMap", archivesMap);
        model.addAttribute("blogCount", blogCount);

        model.addAttribute("newBlogs", blogService.listBlogByOrder(3));
        model.addAttribute("blogCount", blogService.getBlogCount());
        model.addAttribute("blogSumViews", blogService.getBlogSumViews());
        model.addAttribute("blogCommentCount", blogService.getBlogCommentCount());

        return "front/archives";
    }
}
