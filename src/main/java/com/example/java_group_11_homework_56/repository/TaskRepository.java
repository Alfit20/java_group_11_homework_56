package com.example.java_group_11_homework_56.repository;

import com.example.java_group_11_homework_56.entity.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends CrudRepository<Task, Long> {

    Optional<Task> findTaskByIdAndTaskStatus(Long id, String taskStatus);

    Page<Task> findTaskByUserEmail(String email, Pageable pageable);

    Optional<Task> findTaskByIdAndUserEmail(Long id, String email);
}
