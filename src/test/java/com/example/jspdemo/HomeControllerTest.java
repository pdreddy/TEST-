package com.example.jspdemo;

import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(HomeController.class)
class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void homeRendersJspView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("appName", "Spring Boot JSP Demo"))
                .andExpect(model().attribute("serverTime", not(blankOrNullString())));
    }

    @Test
    void greetingUsesSubmittedName() throws Exception {
        mockMvc.perform(post("/greet").param("name", "Sam"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attribute("name", "Sam"));
    }

    @Test
    void blankNameFallsBackToVisitor() throws Exception {
        mockMvc.perform(post("/greet").param("name", "   "))
                .andExpect(status().isOk())
                .andExpect(model().attribute("name", "Visitor"));
    }

    @Test
    void greetingEscapesHtmlInSubmittedName() throws Exception {
        mockMvc.perform(post("/greet").param("name", "<script>"))
                .andExpect(status().isOk())
                .andExpect(model().attribute("name", "&lt;script&gt;"));
    }
}
