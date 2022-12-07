package com.weather.weather.entity;




import lombok.*;

import jakarta.persistence.*;


@Entity
@Table(name = "users")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;


//    @Column(name = "role")
//    private String role;


    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;


//    @ManyToMany
//    @JoinTable(name = "collaborator",
//            joinColumns = @JoinColumn(name = "user_id"),
//            inverseJoinColumns = @JoinColumn(name = "role_id")
//    )
//    private Set<Role> roles;




}
