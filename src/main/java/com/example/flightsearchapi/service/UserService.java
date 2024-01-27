package com.example.flightsearchapi.service;

import com.example.flightsearchapi.dto.UserDto;
import com.example.flightsearchapi.entity.User;
import com.example.flightsearchapi.mapper.UserMapper;
import com.example.flightsearchapi.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;


    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }


    public UserDto save(User user) {
        return userMapper.maptoUserDto(userRepository.save(user));
    }

    public UserDto findByEmail(String email) {
        return userMapper.maptoUserDto(userRepository.findByEmail(email));
    }

    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::maptoUserDto).toList();

    }


}
