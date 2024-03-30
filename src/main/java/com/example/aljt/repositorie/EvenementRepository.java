package com.example.aljt.repositorie;

import com.example.aljt.model.EvenementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EvenementRepository extends JpaRepository<EvenementEntity, Integer> {

    EvenementEntity findByTitle(String title);

    @Modifying
    @Query("insert values into ()")
    EvenementEntity sauvegarder();

    @Modifying
    @Query("UPDATE evenement e SET e.title = :title, e.description = :description WHERE e.id = :id")
    EvenementEntity updateEvent(@Param("id") int id, @Param("title") String title, @Param("description") String description);
}
