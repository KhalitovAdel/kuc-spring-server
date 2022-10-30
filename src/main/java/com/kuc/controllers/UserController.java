package com.kuc.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.kuc.entities.User;
import com.kuc.repositories.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {
    private UserRepository repository;

    UserController(@Autowired UserRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User rawUser) {
        User user = repository.save(rawUser);

        return new ResponseEntity<User>(user, HttpStatus.CREATED); 
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> read(@PathVariable("id") Long id) {
        Optional<User> user = repository.findById(id);

        return new ResponseEntity<User>(user.orElseThrow(), HttpStatus.OK); 
    }

    @GetMapping
    public ResponseEntity<Iterable<User>> list() {
        Iterable<User> users = repository.findAll();

        return new ResponseEntity<Iterable<User>>(users, HttpStatus.OK); 
    }
}
