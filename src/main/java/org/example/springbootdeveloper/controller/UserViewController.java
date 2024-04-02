package org.example.springbootdeveloper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserViewController {
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    @GetMapping("/signup") //회원가입
    public String signup() {
        return "signup";
    }
}
