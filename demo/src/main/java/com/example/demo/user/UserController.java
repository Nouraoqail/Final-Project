package com.example.demo.user;

import com.example.demo.post.Post;
import com.example.demo.post.PostRepository;
import com.example.demo.type.Type;
import com.example.demo.type.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="users")
@CrossOrigin("*")
public class UserController {

    private final UserService UserService;
    private final UserRepository UserRepository;
    private final TypeRepository TypeRepository;

    @Autowired
    public UserController(com.example.demo.user.UserService userService, com.example.demo.user.UserRepository userRepository, com.example.demo.type.TypeRepository typeRepository) {
        UserService = userService;
        UserRepository = userRepository;
        TypeRepository = typeRepository;
    }


    @GetMapping
    public List<User> getUser() {
        return UserService.getUser();
    }

    @GetMapping("/{id}")
    public User getUsers(@PathVariable String id) {
        return UserService.getUsers(id);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return UserService.createUser(user);
    }

    @PutMapping
    public void updateUser(@PathVariable String id, @RequestBody User data) {
        UserService.updateUser(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        UserService.deleteUser(id);
    }
    @PutMapping("/{userId}/types/{typeId}")
    User addTypeToUser(
            @PathVariable Long userId,
            @PathVariable Long typeId
    ) {
        User user = UserRepository.findById(userId).get();
        Type type = TypeRepository.findById(typeId).get();
        user.types.add(type);
        return UserRepository.save(user);
    }
}
