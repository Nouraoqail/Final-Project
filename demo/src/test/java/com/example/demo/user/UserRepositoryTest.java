package com.example.demo.user;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.Table;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class UserRepositoryTest {
private final UserRepository userRepository;

    @Autowired
    public UserRepositoryTest(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Test
    void itShouldFindUser() {
        User user = new User("1099741851","noura123");
        User savedUser = userRepository.save(user);
        User result = userRepository.findById(savedUser.getId()).orElse(null);
        assertNotNull(result);
    }
    @Test
    void itShouldSaveUser() {
        User user = new User("1099741851", "noura123");
        User result = userRepository.save(user);
        assertTrue(result.getId() != 0);
    }

    @Test
    void itShouldFindUserByUsername() {
        String username = "1099";
        User user = new User(username,"1099");
        userRepository.save(user);
        User result = userRepository.findByUsername(username);
        assertEquals(username, result.getUsername());
        assertNotEquals("1099741851", result.getUsername());
    }

    @Test
    void itShouldUpdateUser() {
        User user = new User("1099741851", "noura123");
        userRepository.save(user);
        user.setUsername("1099741851");
        userRepository.save(user);
        assertEquals(user.getUsername(), "1099741851");
    }

    @Test
    void itShouldDeleteUser() {
        User user = new User("1099741851", "noura123");
        userRepository.save(user);
        userRepository.delete(user);
        User result = userRepository.findById(user.getId()).orElse(null);
        assertNull(result);
    }
}