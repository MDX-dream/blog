package com.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 音乐盒页面显示控制器
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 15:31
 */
@Controller
public class MusicShowController {

    @GetMapping("/music")
    public String about() {
        return "music";
    }

}
