package com.lyx.controller.admin;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lyx.bean.Type;
import com.lyx.service.TypeService;
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
public class TypeController {
    @Autowired
    TypeService typeService;

    @GetMapping("/types")
    public String listType(@RequestParam(value = "pn", defaultValue = "1") Integer pn, Model model) {
        PageHelper.startPage(pn, 5);
        List<Type> types = typeService.listType();
        PageInfo pageInfo = new PageInfo(types, 5);

        model.addAttribute("page", pageInfo);

        return "admin/types";
    }

    @PostMapping("/saveType")
    public String saveType(Type type, RedirectAttributes redirectAttributes) {
        Type checkType = typeService.getTypeByName(type.getName());

        if (checkType == null) {
            int count = typeService.saveType(type);
            if (count == 0) {
                redirectAttributes.addFlashAttribute("message", "操作失败");
            } else {
                redirectAttributes.addFlashAttribute("message", "操作成功");
            }

            return "redirect:/admin/types?pn=999";
        } else {
            redirectAttributes.addFlashAttribute("message", "分类名称已存在，请重新输入");

            return "redirect:/admin/saveTypePage";
        }
    }

    @GetMapping("/saveTypePage")
    public String saveTypePage() {

        return "admin/type_save";
    }

    @GetMapping("/updateTypePage")
    public String updateTypePage(@RequestParam Integer id, Model model) {
        Type type = typeService.getType(id);
        model.addAttribute("type", type);

        return "admin/type_update";
    }

    @PostMapping("/updateType")
    public String updateType(Type type, RedirectAttributes redirectAttributes) {
        int count = typeService.updateType(type);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/types";
    }

    @GetMapping("/deleteType")
    public String deleteType(@RequestParam Integer id, RedirectAttributes redirectAttributes) {
        int count = typeService.deleteType(id);
        if (count == 0) {
            redirectAttributes.addFlashAttribute("message", "操作失败");
        } else {
            redirectAttributes.addFlashAttribute("message", "操作成功");
        }

        return "redirect:/admin/types";
    }
}
