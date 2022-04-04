package com.example.java_group_11_homework_56.util;

import com.example.java_group_11_homework_56.entity.User;
import com.example.java_group_11_homework_56.repository.TaskRepository;
import com.example.java_group_11_homework_56.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class InitDatabase {
    private final PasswordEncoder encoder;

    @Bean
    CommandLineRunner init(UserRepository userRepository, TaskRepository taskRepository) {
        return args -> {
            taskRepository.deleteAll();
            userRepository.deleteAll();
            userRepository.save(User.builder()
                    .name("Anton")
                    .email("anton.a@gmail.com")
                    .password(encoder.encode("qwe"))
                    .build());
            userRepository.save(User.builder()
                    .name("Pavel")
                    .email("pavel.p@gmail.com")
                    .password(encoder.encode("asd"))
                    .build());
            userRepository.save(User.builder()
                    .name("Sergey")
                    .email("sergey.s@gmail.com")
                    .password(encoder.encode("zxc"))
                    .build());
        };
    }
}
