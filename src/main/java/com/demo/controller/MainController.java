package com.demo.controller;

import com.demo.exception.CustomException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    @GetMapping("")
    public void main() {
        throw new CustomException();
    }

    @GetMapping("/withCustomMessage")
    public void withCustomMessage() {
        throw new CustomException("Some custom error message");
    }
}
