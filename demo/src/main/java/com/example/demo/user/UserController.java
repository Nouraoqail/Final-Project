package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="users")
@CrossOrigin("*")
public class UserController {

    private final UserService UserService;
    @Autowired
    public UserController(com.example.demo.user.UserService userService) {
        UserService = userService;
    }

    @GetMapping
    public List<User> getUser(){
    return UserService.getUser();
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable String id){
    return UserService.getUsers(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user){
        return UserService.createUser(user);
    }

    @PutMapping
    public void updateUser(@PathVariable String id,@RequestBody User data){
    UserService.updateUser(id,data);
    }
}
