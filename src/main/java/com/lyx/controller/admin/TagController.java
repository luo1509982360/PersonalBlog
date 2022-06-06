package com.lyx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.Tag;
import com.lyx.bean.Type;
import com.lyx.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * @author The setting sun
 * @version 1.0
 * @title: TypeController
 * @description: TODO
 * @date 2022/5/14 15:30
 */
@Controller
@RequestMapping("admin")
public class TagController {
    @Autowired
    TagService tagService;

    @GetMapping("/tags")
    public String listTag(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Tag> tags = tagService.listTag();
        PageInfo pageInfo = new PageInfo(tags, 5);

        model.addAttribute("page", pageInfo);

        return "admin/tags";
    }

    @PostMapping("/saveTag")
    public String saveTag(Tag tag, RedirectAttributes redirectAttributes) {
        Tag checkTag = tagService.getTagByName(tag.getName());

        if (checkTag == null) {
            int count = tagService.saveTag(tag);
            if (count == 0) {
                redirectAttributes.addFlashAttribute("message", "操作失败");
            } else {
                redirectAttributes.addFlashAttribute("message", "操作成功");
            }

            return "redirect:/admin/tags?pn=999";
        } else {
            redirectAttributes.addFlashAttribute("message", "标签名称已存在，请重新输入");

            return "redirect:/admin/saveTagPage";
        }
    }

    @GetMapping("/saveTagPage")
    public String saveTagPage() {

        return "admin/tag_save";
    }

    @GetMapping("/updateTagPage")
    public String updatePage(@RequestParam Integer id, Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag", tag);

        return "admin/tag_update";
    }

    @PostMapping("/updateTag")
    public String updateTag(Tag tag, RedirectAttributes redirectAttributes) {
        int count = tagService.updateTag(tag);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/tags";
    }

    @GetMapping("/deleteTag")
    public String deleteTag(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        int count = tagService.deleteTag(id);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/tags";
    }
}
