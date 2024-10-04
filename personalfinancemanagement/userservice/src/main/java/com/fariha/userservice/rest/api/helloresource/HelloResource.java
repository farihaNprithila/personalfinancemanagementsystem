package com.fariha.userservice.rest.api.helloresource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloResource {

    @GetMapping("/hello")
    public ResponseEntity<?> helloController() {
        return new ResponseEntity<>("hello world", HttpStatus.OK);
    }
}
