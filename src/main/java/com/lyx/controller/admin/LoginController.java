package com.lyx.controller.admin;

import com.lyx.bean.User;
import com.lyx.service.UserService;
import com.lyx.util.MD5Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * @author The setting sun
 * @version 1.0
 * @title: LoginController
 * @description: TODO
 * @date 2022/5/13 19:02
 */
@Controller
@RequestMapping("admin")
public class LoginController {
    @Autowired
    private UserService userService;

    @GetMapping
    public String loginPage() {

        return "admin/login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password,
                        HttpSession session, RedirectAttributes redirectAttributes) {
        User user = userService.checkUser(username, MD5Utils.code(password));
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);

            return "admin/mng_index";
        } else {
            redirectAttributes.addFlashAttribute("message", "用户名和密码错误");

            return "redirect:/admin";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");

        return "redirect:/";
    }
}
