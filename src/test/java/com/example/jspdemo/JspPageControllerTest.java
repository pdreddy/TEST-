package com.example.jspdemo;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(JspPageController.class)
class JspPageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void jspUrlResolvesToMatchingView() throws Exception {
        mockMvc.perform(get("/hello.jsp"))
                .andExpect(status().isOk())
                .andExpect(view().name("hello"));
    }

    @Test
    void nestedPathsAreNotAcceptedByTheGenericRoute() throws Exception {
        mockMvc.perform(get("/folder/hello.jsp"))
                .andExpect(status().isNotFound());
    }
}
