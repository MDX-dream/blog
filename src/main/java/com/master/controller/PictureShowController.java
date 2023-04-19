package com.master.controller;

import com.master.service.PictureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 照片墙页面显示控制器
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 15:31
 */
@Controller
public class PictureShowController {

    @Autowired
    private PictureService pictureService;

    @GetMapping("/picture")
    public String friends(Model model) {
        model.addAttribute("pictures", pictureService.listPicture());
        return "picture";
    }

}
