package com.example.jspdemo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import org.apache.struts2.ActionSupport;

class StrutsHelloActionTest {

    private final StrutsHelloAction action = new StrutsHelloAction();

    @Test
    void executeTrimsTheSubmittedName() {
        action.setName("  Sam  ");

        assertThat(action.execute()).isEqualTo(ActionSupport.SUCCESS);
        assertThat(action.getName()).isEqualTo("Sam");
        assertThat(action.getServerTime()).isNotBlank();
    }

    @Test
    void executeAllowsAnInitialPageRequestWithoutAName() {
        assertThat(action.execute()).isEqualTo(ActionSupport.SUCCESS);
        assertThat(action.getName()).isNull();
    }
}
