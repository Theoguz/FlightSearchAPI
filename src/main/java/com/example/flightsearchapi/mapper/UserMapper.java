package com.example.flightsearchapi.mapper;

import com.example.flightsearchapi.dto.UserDto;
import com.example.flightsearchapi.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Transactional
@Component
public class UserMapper {


    public UserDto maptoUserDto(User source) {
        UserDto target = new UserDto();
        target.setId(source.getId());
        target.setEmail(source.getEmail());
        return target;
    }
}
