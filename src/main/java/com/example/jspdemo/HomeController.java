package com.example.jspdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.util.HtmlUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

    @GetMapping("/")
    public String home(Model model) {
        addCommonAttributes(model);
        return "home";
    }

    @PostMapping("/greet")
    public String greet(@RequestParam(defaultValue = "Visitor") String name, Model model) {
        String displayName = name.strip();
        String greetingName = displayName.isEmpty() ? "Visitor" : displayName;
        model.addAttribute("name", HtmlUtils.htmlEscape(greetingName));
        addCommonAttributes(model);
        return "home";
    }

    private void addCommonAttributes(Model model) {
        model.addAttribute("appName", "Spring Boot JSP Demo");
        model.addAttribute("serverTime", LocalDateTime.now().format(TIME_FORMAT));
    }
}
