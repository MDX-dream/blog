package com.master.controller;

import com.master.service.FriendLinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * <p>
 * 朋友显示控制器
 * </p>
 *
 * @author MDX
 * @since 2023/4/12 15:27
 */
@Controller
public class FriendsShowController {

    @Autowired
    private FriendLinkService friendLinkService;

    @GetMapping("/friends")
    public String friends(Model model) {
        model.addAttribute("friendlinks", friendLinkService.listFriendLink());
        return "friends";
    }

}
