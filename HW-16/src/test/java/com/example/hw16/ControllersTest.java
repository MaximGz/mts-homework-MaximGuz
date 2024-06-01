package com.example.hw16;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest
public class ControllersTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHelloController() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World"));
    }

    @Test
    public void testGreetController() throws Exception {
        mockMvc.perform(post("/greet?name=Max"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Max!"));
    }

    @Test
    public void testDefaultController() throws Exception {
        mockMvc.perform(get("/def"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi Guest!"));
        mockMvc.perform(get("/def?name=John"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hi John!"));
    }

    @Test
    public void testCombineController() throws Exception {
        mockMvc.perform(get("/combine/Max?id=1"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello, Max! Your id is 1"));
        mockMvc.perform(get("/combine"))
                .andExpect(status().isNotFound());
    }

    @Test
    public void testDateController() throws Exception {
        mockMvc.perform(get("/date/2020-02-02"))
                .andExpect(status().isOk())
                .andExpect(content().string("Valid date: 2020-02-02"));
        mockMvc.perform(get("/date/2020-02-0"))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUserControllerUserParams() throws Exception {
        String userJson = "{\"name\":\"Max\", \"email\":\"Max@example.com\"}";
        String userJsonNoName = "{\"email\":\"Max@example.com\"}";
        String userJsonNoEmail = "{\"name\":\"Max\"}";
        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk())
                .andExpect(content().string("User Max with Email: Max@example.com registered successfully."));

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJsonNoEmail))
                .andExpect(status().isBadRequest());

        mockMvc.perform(post("/user")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJsonNoName))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void testUserControllerGetUserById() throws Exception {
        mockMvc.perform(get("/user/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("User not found"));
        mockMvc.perform(get("/user/2"))
                .andExpect(status().isOk())
                .andExpect(content().string("User found"));
        mockMvc.perform(get("/user/3"))
                .andExpect(status().isOk())
                .andExpect(content().string("User found"));
    }

    @Test
    public void testUserControllerGetUserAgent() throws Exception {
        String expectedUserAgent = "test-user-agent";

        mockMvc.perform(MockMvcRequestBuilders.get("/user/uagent")
                        .header("User-Agent", expectedUserAgent))
                .andExpect(status().isOk())
                .andExpect(content().string("User-Agent: " + expectedUserAgent));
    }
}