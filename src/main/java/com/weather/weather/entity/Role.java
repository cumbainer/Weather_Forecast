package com.weather.weather.entity;

import jakarta.persistence.*;

import lombok.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "roles")
@Data
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;



//    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "roles")
//    private Set<User> users;



}
