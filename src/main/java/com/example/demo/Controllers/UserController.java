package com.example.demo.Controllers;

import com.example.demo.Entity.User;
import com.example.demo.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServices userServices;


    @PostMapping("/register")
    public Map<String,String> register(@RequestBody User user){
        HashMap<String, String> response = new HashMap<>();
        User newUser = userServices.register(user);
        response.put("id", newUser.getUserId().toString());
        response.put("username", newUser.getUsername());
        return response;
    }

}
