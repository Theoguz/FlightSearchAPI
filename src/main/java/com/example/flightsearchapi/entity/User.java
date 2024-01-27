package com.example.flightsearchapi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "flight_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    //    @Email(message = "Email should be valid")
    @Column(name = "email", unique = true, nullable = false, length = 45)
    private String email;

    @Column(name = "password", nullable = false, length = 64)
    private String password;

}
