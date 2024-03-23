package com.example.aljt.view.service;

import com.example.aljt.model.EvenementEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface EvenementService {

    public ResponseEntity<List<EvenementEntity>> findAllEvents();

    public ResponseEntity<EvenementEntity> findEvenementById(int id);

    public ResponseEntity<EvenementEntity> findEvenementtByTitle(String title);

    public ResponseEntity<String> saveEvenement(EvenementEntity user);

    public ResponseEntity<String> deleteEvenementById(int id);

    public ResponseEntity<EvenementEntity> updateEvenement(int id, String title, String description);

}
