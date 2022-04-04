package com.example.java_group_11_homework_56.controller;

import com.example.java_group_11_homework_56.dto.TaskDto;
import com.example.java_group_11_homework_56.entity.User;
import com.example.java_group_11_homework_56.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/task")
@RequiredArgsConstructor
@Slf4j
public class TaskController {
    private final TaskService taskService;

    @PostMapping("/create")
    public ResponseEntity<String> createTask(@RequestBody TaskDto taskDto, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        taskService.createTask(taskDto, user);
        return new ResponseEntity<>("Добавлена задача", HttpStatus.OK);
    }
}
