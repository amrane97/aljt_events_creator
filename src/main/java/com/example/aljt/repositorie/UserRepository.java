package com.example.aljt.repositorie;

import com.example.aljt.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer > {
    UserEntity findByEmail(String Email);

    @Modifying
    @Query("UPDATE users u set u.password = :password where u.id= :id")
    UserEntity updateUser(@Param("id") int id, @Param("password") String password);
}
