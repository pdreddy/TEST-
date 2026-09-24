package com.example.jspdemo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import org.apache.struts2.ActionSupport;

@Component("strutsHelloAction")
@Scope("prototype")
public class StrutsHelloAction extends ActionSupport {

    private static final DateTimeFormatter TIME_FORMAT =
            DateTimeFormatter.ofPattern("dd MMM yyyy, hh:mm a");

    private String name;

    @Override
    public String execute() {
        if (name != null) {
            name = name.strip();
        }
        return SUCCESS;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServerTime() {
        return LocalDateTime.now().format(TIME_FORMAT);
    }
}
