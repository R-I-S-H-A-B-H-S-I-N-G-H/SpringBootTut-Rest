package com.example.Rest.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.Rest.user.UserV2.UserV2DaoServices;
import com.example.Rest.user.UserV2.Userv2;

import jakarta.validation.Valid;

@RestController
public class UserResource {
    @Autowired
    private UserDaoService service;

    @Autowired
    private UserV2DaoServices servicesv2;

    // public UserResource(UserDaoService service) {
    // this.service = service;
    // }

    // GET all users
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return service.findAll();
    }

    // POST
    @PostMapping("/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user) {
        User savedUser = service.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // GET /users/id
    @GetMapping("/users/{id}")
    public User getUserbyId(@PathVariable int id) {
        User user = service.findById(id);
        if (user == null)
            throw new UserNotFoundException("this id is not present id :" + id);
        return user;
    }

    // DELETE USER
    @DeleteMapping("/users/{id}")
    public void deleteUserbyIdV2(@PathVariable int id) {
        service.deleteById(id);

    }

    // Version 2
    @GetMapping("/v2/users")
    public List<Userv2> getAllUsersV2() {
        return servicesv2.findAll();
    }

    // POST
    @PostMapping("/v2/users")
    public ResponseEntity<Userv2> createUserV2(@Valid @RequestBody Userv2 user) {
        Userv2 savedUser = servicesv2.createUser(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    // GET /users/id
    @GetMapping("/v2/users/{id}")
    public Userv2 getUserbyIdV2(@PathVariable int id) {
        Userv2 user = servicesv2.findById(id);
        if (user == null)
            throw new UserNotFoundException("this id is not present id :" + id);
        return user;
    }

}
