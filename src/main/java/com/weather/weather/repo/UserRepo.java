package com.weather.weather.repo;

import com.weather.weather.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


//No need @Repository, is does nothing
public interface UserRepo extends JpaRepository<User, Long> {


    //Spring Data should automatically translate the name into @Query, but i wrote my own for clearly purpose
    @Query("""
    SELECT u FROM User u WHERE u.username = :username
    """)
    Optional<User> findUserByUsername(String username);
}
