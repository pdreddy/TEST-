package com.example.jspdemo;

import java.util.EnumSet;

import jakarta.servlet.DispatcherType;

import org.apache.struts2.dispatcher.filter.StrutsPrepareAndExecuteFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StrutsConfiguration {

    /**
     * Runs Struts only below /struts, leaving the Spring MVC routes untouched.
     */
    @Bean
    FilterRegistrationBean<StrutsPrepareAndExecuteFilter> strutsFilter() {
        FilterRegistrationBean<StrutsPrepareAndExecuteFilter> registration =
                new FilterRegistrationBean<>();
        registration.setFilter(new StrutsPrepareAndExecuteFilter());
        registration.setName("struts2");
        registration.addUrlPatterns("/struts/*");
        registration.setDispatcherTypes(EnumSet.of(
                DispatcherType.REQUEST, DispatcherType.FORWARD, DispatcherType.ERROR));
        registration.setOrder(1);
        return registration;
    }
}
