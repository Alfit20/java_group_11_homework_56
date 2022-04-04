package com.example.java_group_11_homework_56.service;

import com.example.java_group_11_homework_56.dto.TaskDto;
import com.example.java_group_11_homework_56.entity.Task;
import com.example.java_group_11_homework_56.entity.User;
import com.example.java_group_11_homework_56.enums.TaskStatusEnum;
import com.example.java_group_11_homework_56.repository.TaskRepository;
import com.example.java_group_11_homework_56.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    // Создать задачу
    public void createTask(TaskDto taskDto, User user) {
        var email = userRepository.findUserByEmail(user.getEmail());
        taskRepository.save(Task.builder()
                .title(taskDto.getTitle())
                .description(taskDto.getDescription())
                .dateOfCompletion(taskDto.getDateOfCompletion())
                .user(email)
                .taskStatus(TaskStatusEnum.NEW.getValue())
                .build());
    }
}
