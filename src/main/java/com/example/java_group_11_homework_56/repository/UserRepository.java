package com.example.java_group_11_homework_56.repository;

import com.example.java_group_11_homework_56.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> getByEmail(String email);

    User findUserByEmail(String email);


}
