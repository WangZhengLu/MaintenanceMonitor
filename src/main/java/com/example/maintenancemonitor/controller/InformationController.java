package com.example.maintenancemonitor.controller;

import com.example.maintenancemonitor.service.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
