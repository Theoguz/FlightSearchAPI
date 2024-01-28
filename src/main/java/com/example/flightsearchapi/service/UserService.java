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

    public void save(User user) {
        userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findById(id).get();
    }

    public User deleteById(Long id) throws Exception {
        User user = userRepository.findById(id).get();
        if (user != null) {
            userRepository.deleteById(id);
            return user;
        } else {
            throw new Exception("User not found");
        }
    }
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        return users.stream().map(userMapper::maptoUserDto).toList();
    }
}
