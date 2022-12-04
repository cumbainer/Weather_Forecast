package com.weather.weather.repo;

import com.weather.weather.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {

    @Query("""
    SELECT u from User u WHERE u.username = :username
    """)
    public Optional<User> findUserByUsername(String username);
}
