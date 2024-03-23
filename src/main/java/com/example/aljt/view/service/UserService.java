package com.example.aljt.view.service;

import com.example.aljt.model.UserEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {

    public ResponseEntity<List<UserEntity>> findAllUsers();

    public ResponseEntity<UserEntity> findUserById(int id);

    public ResponseEntity<UserEntity> findUserByEmail(String email);

    public ResponseEntity<UserEntity> saveUser(UserEntity user);

    public ResponseEntity<String> deleteUserById(int id);

    public ResponseEntity<UserEntity> updatePassword(int id, String newPassword);

}
