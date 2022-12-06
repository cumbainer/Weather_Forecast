package com.weather.weather.service;

import com.weather.weather.repo.UserRepo;
import com.weather.weather.security.SecurityUser;
import lombok.AllArgsConstructor;

import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

//No Arg con requeired for working properly
@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {


    private UserRepo userRepo;
    protected final Log logger = LogFactory.getLog(getClass());







    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepo.findUserByUsername(username);
        logger.info("loadUserByUsername USERNAME= "+username);


        return user.map(SecurityUser::new).orElseThrow(() -> new UsernameNotFoundException("user" + username + "not found"));
    }
}
