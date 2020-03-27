package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.UserRepository;
import com.assignment1.wasteless.Presentation.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "userId") Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not availbele for Id :" + userId));

        return ResponseEntity.ok().body(user);
    }

}
