package com.example.aljt.controller;

import com.example.aljt.model.EvenementEntity;
import com.example.aljt.view.implemantation.EvenementImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evenement")
public class EventController {

    @Autowired
    public EvenementImpl evenement;

    @GetMapping("/all")
    public ResponseEntity<List<EvenementEntity>> getAllEvents() {
        return evenement.findAllEvents();
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<EvenementEntity> findEventById(@PathVariable int id) {
         return evenement.findEvenementById(id);
    }

    @GetMapping("/findByTitle/{title}")
    public ResponseEntity<EvenementEntity> findEventByTitle (@PathVariable String title) {
        return evenement.findEvenementtByTitle(title);
    }

    @PostMapping("/save")
    public ResponseEntity<String> save(@RequestBody EvenementEntity event) {
        return evenement.saveEvenement(event);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable int id) {
        return evenement.deleteEvenementById(id);
    }

/*
    @PutMapping("/update/{id}")
    public ResponseEntity<EvenementEntity> update (@PathVariable int id, String title, String description) {
        return evenement.updateEvenement(id, title, description);
    } */
}
