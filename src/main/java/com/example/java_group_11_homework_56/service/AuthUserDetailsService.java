package com.example.java_group_11_homework_56.service;

import com.example.java_group_11_homework_56.dto.UserDto;
import com.example.java_group_11_homework_56.entity.User;
import com.example.java_group_11_homework_56.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;
    private final PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getByEmail(username).orElseThrow(() -> new UsernameNotFoundException("Not found"));
    }

    public void registration(UserDto userDto) {
        var email = userRepository.findUserByEmail(userDto.getEmail());
        if (email == null) {
            userRepository.save(User.builder()
                    .name(userDto.getName())
                    .email(userDto.getEmail())
                    .password(encoder.encode(userDto.getPassword()))
                    .build());
        } else {
            throw new NullPointerException();
        }
    }
}
