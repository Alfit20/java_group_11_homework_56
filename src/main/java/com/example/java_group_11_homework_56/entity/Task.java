package com.example.java_group_11_homework_56.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;

    @Column(name = "date_of_completion")
    private LocalDateTime dateOfCompletion;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column(name = "task_status")
    private String taskStatus;
}
