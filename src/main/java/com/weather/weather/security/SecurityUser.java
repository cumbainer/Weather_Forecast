package com.weather.weather.security;



import com.weather.weather.entity.User;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
//This class is needed for recognizing Spring Security what to return in method loadUserByUsername() in CustomUserDetailsService class
public class SecurityUser implements UserDetails {

    //This entity we are trying to convert to return(wrapping SecurityUser class over the User class just for recognizing it from Spring Security side
    private User user;
    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public String getUsername() {
        logger.info("User ROLE: " + user.getRoles());
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
        return user.getRoles()
                .stream()
                .map(SecurityAuthority::new)//is needs to be recognized from Spring Security
                .collect(Collectors.toList());
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
