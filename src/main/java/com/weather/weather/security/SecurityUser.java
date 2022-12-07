package com.weather.weather.security;



import com.weather.weather.entity.User;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@AllArgsConstructor

//This class is needed for recognizing Spring Security what to return in method loadUserByUsername() in CustomUserDetailsService class
public class SecurityUser implements UserDetails {

    //This entity we are trying to convert to return(wrapping SecurityUser class over the User class just for recognizing it from Spring Security side
    private User user;
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public String getUsername() {
        return user.getUsername();

    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }



    @Override

    //This method represents what users are allowed to do(authorities)
    //ToDo replace after with not static impl
    public Collection<? extends GrantedAuthority> getAuthorities() {
          var roles = user.getRole();
//        List<GrantedAuthority> roleList = new ArrayList<>();
//        for(var a: roles){
//            roleList.add(new SimpleGrantedAuthority("ROLE_" + a.getName() ));
//        }
//
//        return roleList;
        List<GrantedAuthority> roleList = new ArrayList<>();
        roleList.add(new SimpleGrantedAuthority("ROLE_" +user.getRole()));
        return roleList;

    }

    //All is true
    //ToDo implement it later

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


}
