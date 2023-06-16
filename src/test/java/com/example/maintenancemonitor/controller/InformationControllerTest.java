package com.example.maintenancemonitor.controller;

import com.example.maintenancemonitor.service.InformationService;
import junit.framework.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class InformationControllerTest {

    @Mock
    private InformationService informationService;

    @InjectMocks
    private InformationController informationController = new InformationController();

    @Test
    public void testGetMessage() throws Exception {
        String message = "Everything works as expected";
        when(informationService.getMessage()).thenReturn(message);
        String result = informationController.getMessage();
        Assert.assertEquals(result, message);
    }

    @Test
    public void testSetMessage() throws Exception {
        String result = informationController.setMessage("test");
        Assert.assertEquals(result, "ok");
    }

    @Test
    public void testRestMessage() throws Exception {
        String result = informationController.restMessage();
        Assert.assertEquals(result, "ok");
    }
}