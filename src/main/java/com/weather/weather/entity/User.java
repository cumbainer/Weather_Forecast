package com.weather.weather.entity;

import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    private String username;


    private String password;
}
