package com.example.Auth_Service.service;

import com.example.Auth_Service.model.User;
import com.example.Auth_Service.repositiory.UserRepository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User>  findByEmail (String email){



          return userRepository.findByEmail(email);

    }
}
