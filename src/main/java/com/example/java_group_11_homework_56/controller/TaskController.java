package com.example.java_group_11_homework_56.controller;

import com.example.java_group_11_homework_56.dto.TaskDto;
import com.example.java_group_11_homework_56.entity.User;
import com.example.java_group_11_homework_56.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public Slice<TaskDto> toDoList(Authentication authentication, Pageable pageable) {
        User user = (User) authentication.getPrincipal();
        return taskService.toDoList(user, pageable);
    }

    @GetMapping("/details/{id}")
    public ResponseEntity<List<TaskDto>> detailsById(@PathVariable Long id, Authentication authentication) {
        try {
            User user = (User) authentication.getPrincipal();
            return new ResponseEntity<>(taskService.detailsOfYourTask(id, user), HttpStatus.OK);
        } catch (NullPointerException npe) {
            log.error("Неправильный id задачи");
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
