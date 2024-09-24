package com.example.demo.Services;

import com.example.demo.Entity.User;

public interface UserServices {
    User login(String username, String password);
    User register(User user);

}
