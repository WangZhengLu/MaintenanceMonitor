package com.example.maintenancemonitor.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InformationServiceTest {

    @Test
    public void testGetMessage() {
        InformationService informationService = new InformationService();
        Assertions.assertEquals("Everything works as expected", informationService.getMessage());
    }

    @Test
    public void testSetMessage() {
        InformationService informationService = new InformationService();
        informationService.setMessage("new message");
        Assertions.assertEquals("new message", informationService.getMessage());
    }

    @Test
    public void testRestMessage() {
        InformationService informationService = new InformationService();
        informationService.setMessage("new message");
        informationService.restMessage();
        Assertions.assertEquals("Everything works as expected", informationService.getMessage());
    }
}