package com.example.flightsearchapi.repository;

import com.example.flightsearchapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
