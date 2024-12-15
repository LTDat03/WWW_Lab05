/*
 * @ (#) AuthController.java       1.0     12/12/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.frontend.controllers;
/*
 * @description:
 * @author: Luong Tan Dat
 * @date: 12/12/2024
 */

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import vn.edu.iuh.fit.lab05_week05_21026661_luongtandat.backend.models.User;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String login(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "auth/login";
    }

    @GetMapping("/register")
    public String register(Model model){
        return "auth/register";
    }

    @GetMapping("/personal")
    public String personal(Authentication authentication){
        if(authentication != null && authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("CANDIDATE"))){
            return "redirect:/home";
        }else{
            return "auth/login";
        }
    }
}
