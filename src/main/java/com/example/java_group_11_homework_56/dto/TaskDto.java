package com.example.java_group_11_homework_56.dto;

import com.example.java_group_11_homework_56.entity.Task;
import com.example.java_group_11_homework_56.entity.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TaskDto {
    private Long id;
    private String title;
    private String description;
    @JsonProperty("date_of_completion")
    private LocalDateTime dateOfCompletion;
    @JsonProperty("user_id")
    private User user;
    @JsonProperty("task_status")
    private String taskStatus;

    public static TaskDto from(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .taskStatus(task.getTaskStatus())
                .dateOfCompletion(task.getDateOfCompletion())
                .build();
    }

    public static TaskDto toTaskDto(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .dateOfCompletion(task.getDateOfCompletion())
                .user(task.getUser())
                .taskStatus(task.getTaskStatus())
                .build();
    }
}
