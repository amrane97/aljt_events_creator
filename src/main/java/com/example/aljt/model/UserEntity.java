package com.example.aljt.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import java.io.Serializable;

@EnableAutoConfiguration
@Entity(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int user_id;

    @Column
    private String login;

    @Column
    private String password;

    @Column
    private String email;
    /*
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<EvenementEntity> evenements = new ArrayList<>(); */
}
