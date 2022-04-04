package com.example.java_group_11_homework_56.controller;

import com.example.java_group_11_homework_56.dto.UserDto;
import com.example.java_group_11_homework_56.service.AuthUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/registration")
@RequiredArgsConstructor
public class RegistrationController {
    private final AuthUserDetailsService service;

    @PostMapping
    public ResponseEntity<String> userRegistration(@RequestBody UserDto userDto) {
        try {
            service.registration(userDto);
            return new ResponseEntity<>("Успешная регистрация", HttpStatus.OK);
        } catch (NullPointerException npe) {
            return new ResponseEntity<>("Такая почта уже существует", HttpStatus.BAD_REQUEST);
        }
    }
}
