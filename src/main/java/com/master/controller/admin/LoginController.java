package com.master.controller.admin;

import com.master.entity.User;
import com.master.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * <p>
 * 用户登录控制器
 * </p>
 *
 * @author MDX
 * @since 2023/4/11 22:49
 */
@Controller
@RequestMapping("/admin")
public class LoginController {
    @Autowired
    private UserService userService;

    /**
     * @return 返回登录页面
     * @Description 跳转登录页面
     */
    @GetMapping
    public String loginPage() {
        return "admin/login";
    }

    /**
     * @param username   用户名
     * @param password   密码
     * @param session    session域
     * @param attributes 返回页面消息
     * @return 登录成功跳转登录成功页面，登录失败返回登录页面
     * @Description 登录校验
     */
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        HttpSession session,
                        RedirectAttributes attributes) {
        User user = userService.checkUser(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user", user);
            session.setMaxInactiveInterval(-1);     // 设置session永不过期
            return "admin/index";
        } else {
            attributes.addFlashAttribute("message", "用户名和密码错误");
            return "redirect:/admin";
        }
    }
//    @PostMapping("/login")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        HttpSession session,
//                        RedirectAttributes attributes) {
//        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
//        queryWrapper.eq(User::getUsername,username)
//                    .eq(User::getPassword,password);
//        User user = userService.getOne(queryWrapper);
////        User user = userService.checkUser(username, password);
//        if (user != null) {
//            user.setPassword(null);
//            session.setAttribute("user",user);
//            session.setMaxInactiveInterval(-1);
//            return "admin/index";
//        } else {
//            attributes.addFlashAttribute("message", "用户名和密码错误");
//            return "redirect:/admin";
//        }
//    }

    /**
     * @param session:session域
     * @return 返回登录页面
     * @Description 注销
     */
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
