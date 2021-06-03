package com.medinatello.testprodigio.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;


@ExtendWith(SpringExtension.class)
@WebMvcTest(value = PingController.class)
class PingControllerTest {

    private PingController controller;

    @Test
    @DisplayName("ping services online")
    public void pingTest() {
        var pong = "pong";
        controller = new PingController();
        var response = controller.ping();
        var body = response.getBody();
        assertThat(response.getStatusCode().value(), equalTo(HttpStatus.OK.value()));
        assertThat(pong, equalTo( body ) );
    }

}