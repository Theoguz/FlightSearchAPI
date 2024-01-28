package com.example.flightsearchapi.service;

import com.example.flightsearchapi.entity.User;
import com.example.flightsearchapi.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {

    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }



}
