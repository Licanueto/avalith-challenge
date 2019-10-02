package com.avalith.challenge.challenge.controller;

import com.avalith.challenge.challenge.Model.User;
import com.avalith.challenge.challenge.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public void addUser(@RequestBody User user){
        this.userService.addUser(user);
    }
    @PostMapping("/addBulk")
    public void addBulk(@RequestBody List<User> users){
        this.userService.bulkImport(users);
    }

    @GetMapping("/all")
    public List<User> getUsers(){
        return this.userService.getAll();
    }

    @GetMapping(path = "{id}")
    public User getUser(@PathVariable UUID id){
        return this.userService.retrieveById(id);
    }
    @DeleteMapping(path = "{id}")
    public void deleteUser(@PathVariable UUID id){
        this.userService.deleteUser(id);
    }
}
