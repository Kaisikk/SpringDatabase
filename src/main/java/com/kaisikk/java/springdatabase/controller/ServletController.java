package com.kaisikk.java.springdatabase.controller;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServletController {

    @GetMapping("/index")
    public String getIndex(Model model) {
        model.addAttribute("message", "ok, u can do it");
        return "index";
    }

    @GetMapping("/cookie")
    public String getCookie(HttpServletResponse httpServletResponse) {
        httpServletResponse.addCookie(new Cookie("kaisik", "kaisik"));
        return "cookie";
    }

}
