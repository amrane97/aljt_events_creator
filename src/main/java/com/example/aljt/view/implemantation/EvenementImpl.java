package com.example.aljt.view.implemantation;

import com.example.aljt.model.EvenementEntity;
import com.example.aljt.repositorie.EvenementRepository;
import com.example.aljt.view.service.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class EvenementImpl implements EvenementService {

    @Autowired
    public EvenementRepository evenementRepository;

    @Override
    public ResponseEntity<List<EvenementEntity>> findAllEvents() {
        return new ResponseEntity<List<EvenementEntity>>(evenementRepository.findAll(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<EvenementEntity> findEvenementById(int id) {
        Optional<EvenementEntity> ee = evenementRepository.findById(id);
        if(ee.isPresent()) {
            EvenementEntity event = ee.get();
            return new ResponseEntity<EvenementEntity>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @Override
    public ResponseEntity<EvenementEntity> findEvenementtByTitle(String title) {
        EvenementEntity event = evenementRepository.findByTitle(title);
        if (event != null) {
            return new ResponseEntity<>(event, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @Override
    public ResponseEntity<String> saveEvenement(EvenementEntity event) {
        evenementRepository.save(event);
        return new ResponseEntity<String>("OK - Event Added", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> deleteEvenementById(int id) {
        evenementRepository.deleteById(id);
        return new ResponseEntity<String>("OK - Event Deleted", HttpStatus.OK);
    }

    @Override
    public ResponseEntity<EvenementEntity> updateEvenement(int id, String title, String description) {
        evenementRepository.updateEvent(id, title,description);
        EvenementEntity ev = evenementRepository.findByTitle(title);
        if (ev != null) {
            return new ResponseEntity<EvenementEntity>(ev, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
