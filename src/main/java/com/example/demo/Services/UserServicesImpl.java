package com.example.demo.Services;

import com.example.demo.Entity.User;
import com.example.demo.Exception.UsernameAlreadyTakenException;
import com.example.demo.Repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices{

    @Autowired
    private UserRepository userRepository;
    @Override
    public User login(String username, String password) {
        User user = userRepository.findByUsername(username);
        if(user!= null && new BCryptPasswordEncoder().matches(password,user.getPassword())){
            return user;
        }
        throw new BadCredentialsException("Invalid password for user: " + username);
    }

    @Override
    public User register(User user) {
       User chackUser = userRepository.findByUsername(user.getUsername());
       if(chackUser != null){
           throw new UsernameAlreadyTakenException("Choose another username");
       }
       chackUser = userRepository.findUserByMail(user.getMail());
       if(chackUser != null){
           throw new RuntimeException("This mail has used before");
       }
       user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
       return userRepository.save(user);
    }
}
