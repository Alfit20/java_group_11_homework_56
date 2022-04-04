package com.example.java_group_11_homework_56.service;

import com.example.java_group_11_homework_56.dto.TaskDto;
import com.example.java_group_11_homework_56.entity.Task;
import com.example.java_group_11_homework_56.entity.User;
import com.example.java_group_11_homework_56.enums.TaskStatusEnum;
import com.example.java_group_11_homework_56.repository.TaskRepository;
import com.example.java_group_11_homework_56.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    // Список своих дел
    public Slice<TaskDto> toDoList(User user, Pageable pageable) {
        var slice = taskRepository.findTaskByUserEmail(user.getEmail(), pageable);
        return slice.map(TaskDto::from);
    }

    // просматривать детали своей задачи по ее идентификатору
    public List<TaskDto> detailsOfYourTask(Long id, User user) {
        var task = taskRepository.findTaskByIdAndUserEmail(id, user.getEmail()).orElseThrow(NullPointerException::new);
        List<TaskDto> taskDtos = new ArrayList<>();
        taskDtos.add(TaskDto.toTaskDto(task));
        return taskDtos;

    }
}
