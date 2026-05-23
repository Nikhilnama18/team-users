package com.nikhil.group.service;

import com.nikhil.group.entity.User;
import com.nikhil.group.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(String name, String email){
        User user = User.builder().name(name).email(email).build();

        return userRepository.save(user);
    }

    public User getUserById(UUID userId){
        return userRepository.findById(userId).orElseThrow(()-> new RuntimeException("User not found"));
    }

    public User updateUser(UUID userId, String name, String email){
        User user = getUserById(userId);

        if (name != null && !name.isBlank()) {
            user.setName(name);
        }

        if (email != null && !email.isBlank()) {
            user.setEmail(email);
        }

        return userRepository.save(user);

    }
}
