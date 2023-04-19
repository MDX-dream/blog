package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 关于我界面显示控制器
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 15:24
 */
@Controller
public class AboutShowController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

}
