package com.example.aljt.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.io.Serializable;
import java.time.LocalDate;

@EnableAutoConfiguration
@Entity(name = "evenement")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EvenementEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer evenement_id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String date;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",
            referencedColumnName = "user_id",
            insertable = true,
            updatable = true)
    private UserEntity user;
}
