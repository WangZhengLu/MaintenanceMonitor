package com.example.maintenancemonitor.controller;

import com.example.maintenancemonitor.service.InformationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;

@Controller
public class InformationController {
    @Autowired
    InformationService informationService;

    @GetMapping("/api/message")
    @ResponseBody
    public String getMessage() {
        return informationService.getMessage();
    }

    @PostMapping("/api/message/set")
    @ResponseBody
    public String setMessage(String m) {
        informationService.setMessage(m);
        return "ok";
    }

    @PostMapping("/rest")
    @ResponseBody
    public String restMessage() {
        informationService.restMessage();
        return "ok";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Model model, String username, String password) {
        if (Objects.equals(username, "1") && Objects.equals(password, "1")) {
            HttpSession session = request.getSession();
            session.setAttribute("login", true);
            return "index";
        }
        if (username != null || password != null) {
            model.addAttribute("error", "username or password invalid");
        }
        return "login";
    }

    @RequestMapping("/loginOut")
    public String loginOut(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.invalidate();
        return "redirect:/";
    }
}
