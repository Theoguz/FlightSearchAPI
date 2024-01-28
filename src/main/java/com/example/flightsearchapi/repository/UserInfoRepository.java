package com.example.flightsearchapi.repository;

import com.example.flightsearchapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserInfoRepository extends JpaRepository<User, Long> {

    Optional<User> findByName(String username);

}
