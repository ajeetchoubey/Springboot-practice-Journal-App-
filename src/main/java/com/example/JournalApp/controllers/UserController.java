package com.example.JournalApp.controllers;


import com.example.JournalApp.entities.User;
import com.example.JournalApp.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping
    public List<User> getAllUsers(){
       return userService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user){
        User checkUser = userService.findByUsername(user.getUserName());
        if(user.getUserName().equals(checkUser.getUserName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists");
        }
        userService.saveEntry(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{userName}")
    public ResponseEntity<?> updateUser(@RequestBody User user, @PathVariable String userName){
        User userInDb = userService.findByUsername(userName);
        if(userInDb != null){
            userInDb.setUserName(user.getUserName());
            userInDb.setPassword(user.getPassword());
            userService.saveEntry(userInDb);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
