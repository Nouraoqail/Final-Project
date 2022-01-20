package com.example.demo.user;

import com.example.demo.type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(path="users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;
//    private final UserRepository userRepository;
//    private final TypeRepository typeRepository;

    public UserController(UserService userService) {
        this.userService = userService;
//        this.userRepository = userRepository;
//        this.typeRepository = typeRepository;
    }

    @GetMapping
    public List<User> getUser() {
        return userService.getUser();
    }

    @GetMapping("ById/{id}")
    public User getUsers(@PathVariable String id) {
        return userService.getUsers(id);
    }

    @GetMapping("/{username}")
    public User getUserByUserName(@PathVariable String username) {
        return userService.getUserByUserName(username);
    }


    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable String id, @RequestBody User data) {

        return userService.updateUser(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(id);
    }

    @PostMapping("/addType")
    public User addTypeToUser(@RequestBody User user) {

        return userService.addTypeToUser(user);
    }
}
