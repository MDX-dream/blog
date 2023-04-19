package com.master.controller;

import com.master.service.MemoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 时间轴页面显示控制器
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 15:25
 */
@Controller
public class ArchiveShowController {

    @Autowired
    private MemoryService memoryService;

    @GetMapping("/archives")
    public String archive(Model model) {
        model.addAttribute("memorys", memoryService.listMemory());
        return "archives";
    }

}
