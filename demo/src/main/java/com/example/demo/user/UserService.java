package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository UserRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        UserRepository = userRepository;
    }

    public List<User> getUser(){
    return UserRepository.findAll();
    }

    public User getUsers(String id){
    Long user_id= Long.parseLong(id);
    return UserRepository.findById(user_id).orElse(null);
    }

    public User createUser(User user){
    return UserRepository.save(user);
    }

    public void updateUser(String id,User data){
    Long user_id =Long.parseLong(id);
    User user= UserRepository.findById(user_id).orElse(null);

    if(user != null){
        user.setNID(data.getNID());
        user.setFName(data.getFName());
        user.setLName(data.getLName());
        user.setPhone_number(data.getPhone_number());
        user.setPassword(data.getPassword());

    }
    }

}
