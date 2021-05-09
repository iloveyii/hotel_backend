package com.cms.backend.controllers;


import com.cms.backend.data.QuestionRepository;
import com.cms.backend.data.UserRepository;
import com.cms.backend.models.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/api/v1/users")
    public Result createUser(@RequestBody User user) throws JsonProcessingException {
        userRepository.save(user);
        return new Result(true, "User saved");
    }

    @PutMapping("/api/v1/users/{id}")
    public Result updateUser(@RequestBody User user, @PathVariable  Integer id) throws JsonProcessingException {
        userRepository.save(user);
        return new Result(true, "User saved");
    }

    @GetMapping("/api/v1/users")
    public ResponseUser getUsers() throws JsonProcessingException {
        return new ResponseUser(true, userRepository.findAll());
    }

    @DeleteMapping("/api/v1/users/{id}")
    public Result deleteUser(@PathVariable  Integer id) throws JsonProcessingException {
        Result result = new Result(true, "User deleted with id " + id );
        Optional<User> user =  userRepository.findById(id);

        if(user.isPresent()) {
            userRepository.deleteById(id);
        }
        return result;
    }
}
