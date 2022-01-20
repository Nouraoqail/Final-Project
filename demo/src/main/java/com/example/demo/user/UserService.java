package com.example.demo.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static java.lang.Long.parseLong;

@Service
public class UserService implements UserDetailsService{
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user= userRepository.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("User not exist");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();

        authorities.add(new SimpleGrantedAuthority(user.getRole()));


        return new org.springframework.security.core.userdetails.User(user.getUsername(),user.getPassword(),authorities);
    }

//    public List<User> getUsers(){
//        return userRepository.findAll();
//    }
    public User getUsers(String id){
        Long user_id= Long.parseLong(id);
        return userRepository.findById(user_id).orElse(null);
    }
    public User createUser(User user){

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User updateUser(String id,User data){
            Long user_id =Long.parseLong(id);
            User user= userRepository.findById(user_id).orElse(null);

            if(user != null){
                user.setFName(data.getFName());
                user.setLName(data.getLName());
                user.setPhone_number(data.getPhone_number());
                userRepository.save(user);


            }
            return user;
        }


    public User addTypeToUser(User user) {
        User u = userRepository.findById(user.getId()).orElse(null);
        u.setTypes(user.getTypes());
        return userRepository.save(u);
    }

    public void deleteUser(String id){
        Long user_id=Long.parseLong(id);
        userRepository.deleteById(user_id);
    }

    public List<User> getUser() {
        return userRepository.findAll();
    }


    public User getUserByUserName(String username) {
        return userRepository.findByUsername(username);
    }
}
