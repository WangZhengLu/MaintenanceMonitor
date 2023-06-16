package com.example.maintenancemonitor.service;

import org.springframework.stereotype.Service;

@Service
public class InformationService {
    private String message = "Everything works as expected";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void restMessage() {
        this.message = "Everything works as expected";
    }
}
