package com.demo.controller;

import com.demo.exception.CustomException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

public class MainControllerAdviceTest {
    @InjectMocks
    private MainControllerAdvice target;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void handleException_whenErrorMessageIsNull_thenReturnDefaultErrorMessage() {
        ResponseEntity<String> actual = target.handleException(new CustomException(null));

        assertThat(actual).isNotNull();
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        assertThat(actual.getBody()).isEqualTo("Something went wrong");
    }

    @Test
    public void handleException_whenErrorMessageIsEmpty_thenReturnDefaultErrorMessage() {
        ResponseEntity<String> actual = target.handleException(new CustomException(""));

        assertThat(actual).isNotNull();
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        assertThat(actual.getBody()).isEqualTo("Something went wrong");
    }

    @Test
    public void handleException_whenErrorMessageHasValue_thenReturnErrorMessageValue() {
        ResponseEntity<String> actual = target.handleException(new CustomException("Some custom error message"));

        assertThat(actual).isNotNull();
        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.NETWORK_AUTHENTICATION_REQUIRED);
        assertThat(actual.getBody()).isEqualTo("Some custom error message");
    }
}
