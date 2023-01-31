package com.example.Rest.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    // public UserResource(UserDaoService service) {
    // this.service = service;
    // }

    // GET all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    // GET /users/id
    @GetMapping("/users/{id}")
    public User getUserbyId(@PathVariable int id) {
        User user = service.findById(id);
        if (user == null)
            throw new UserNotFoundException("id :" + id);
        return user;
    }

    // POST
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = service.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }
}
