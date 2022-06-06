package com.lyx.controller.admin;

import com.lyx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author The setting sun
 * @version 1.0
 * @title: AdminController
 * @description: TODO
 * @date 2022/5/12 14:55
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @GetMapping("/mngIndex")
    public String mngIndex() {

        return "admin/mng_index";
    }
}
