package com.example.maintenancemonitor.controller;

import com.example.maintenancemonitor.service.InformationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest({InformationController.class, InformationService.class})
public class InformationControllerTest2 {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testValidLogin() throws Exception {
        // Given
        String username = "1";
        String password = "1";

        // When-Then
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", username)
                        .param("password", password)
                        .session(mock(MockHttpSession.class)))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    public void testInvalidLogin() throws Exception {
        // Given
        String username = "invalid";
        String password = "invalid";

        // When-Then
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", username)
                        .param("password", password)
                        .session(mock(MockHttpSession.class)))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(request().attribute("error", "username or password invalid"))
                .andExpect(request().sessionAttributeDoesNotExist("login"));
    }

    @Test
    public void testNullUsernameAndPassword() throws Exception {
        // Given

        // When-Then
        mockMvc.perform(post("/login")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .param("username", "")
                        .param("password", "")
                        .session(mock(MockHttpSession.class)))
                .andExpect(status().isOk())
                .andExpect(view().name("login"))
                .andExpect(request().sessionAttributeDoesNotExist("login"));
    }

    @Test
    public void testLogout() throws Exception {
        // Given

        // When-Then
        mockMvc.perform(get("/loginOut")
                        .session(mock(MockHttpSession.class)))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/"))
                .andExpect(request().sessionAttributeDoesNotExist("login"));
    }
}