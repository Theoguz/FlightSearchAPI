package com.example.flightsearchapi.controller;

import com.example.flightsearchapi.dto.UserDto;
import com.example.flightsearchapi.entity.User;
import com.example.flightsearchapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/user")


public class UserController {

    private final UserService userService;  //@Autowired

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public UserDto addAccount(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/all")
    public List<UserDto> GetAllUsers() {
        return userService.getAll();
    }

    @GetMapping("/{email}")
    public UserDto findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
