package com.weather.weather.service;

import com.weather.weather.entity.User;

import java.util.List;

public interface UserService {
    public User create(User user);
    public User readById(long id);
    public void delete(long id);
    public List<User> getAll();


}
