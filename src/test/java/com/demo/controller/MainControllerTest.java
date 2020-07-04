package com.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class MainControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void main() throws Exception {
        mockMvc.perform(get("/"))
                .andDo(print())
                .andExpect(status().isNetworkAuthenticationRequired())
                .andExpect(content().string(equalTo("Something went wrong")));
    }

    @Test
    public void withCustomMessage() throws Exception {
        mockMvc.perform(get("/withCustomMessage"))
                .andDo(print())
                .andExpect(status().isNetworkAuthenticationRequired())
                .andExpect(content().string(equalTo("Some custom error message")));
    }
}
