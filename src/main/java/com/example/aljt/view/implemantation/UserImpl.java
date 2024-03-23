package com.example.aljt.view.implemantation;

import com.example.aljt.model.UserEntity;
import com.example.aljt.repositorie.UserRepository;
import com.example.aljt.view.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImpl implements UserService {

    @Autowired
    public UserRepository userRepository;

    @Override
    public ResponseEntity<List<UserEntity>> findAllUsers() {
        return new ResponseEntity<List<UserEntity>>(userRepository.findAll(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> findUserById(int id) {
        Optional<UserEntity> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            UserEntity ue = optionalUser.get();
            return new ResponseEntity<UserEntity>(ue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public ResponseEntity<UserEntity> findUserByEmail(String email) {

        return new ResponseEntity<>(userRepository.findByEmail(email), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserEntity> saveUser(UserEntity user) {
        return new ResponseEntity<UserEntity>(userRepository.save(user),  HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteUserById(int id) {
        userRepository.deleteById(id);
        return new ResponseEntity<String>("OK - User Deleted", HttpStatus.OK);
    }


    @Override
    public ResponseEntity<UserEntity> updatePassword(int id, String password) {
        return new ResponseEntity<UserEntity>(userRepository.updateUser(id, password), HttpStatus.OK);
    }

}
