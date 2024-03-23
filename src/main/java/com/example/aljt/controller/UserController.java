package com.example.aljt.controller;


import com.example.aljt.model.UserEntity;
import com.example.aljt.view.implemantation.UserImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    public UserImpl user;

    @GetMapping("/all")
    public ResponseEntity<List<UserEntity>> getAllEvents() {
        return user.findAllUsers();
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> findEventById(@PathVariable int id) {
        return user.findUserById(id);
    }

    @GetMapping("/find/{email}")
    public ResponseEntity<UserEntity> findEventByEmail (@PathVariable String email) {
        return user.findUserByEmail(email);
    }

    @PostMapping("/save")
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity us) {
        return user.saveUser(us);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return user.deleteUserById(id);
    }
/*
    @PutMapping("/update/{id}")
    public ResponseEntity<UserEntity> update (@PathVariable int id, String password) {
        return user.updatePassword(id, password);
    }*/

}
