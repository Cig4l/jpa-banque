package org.example;

import jakarta.persistence.*;

@Entity
@Table(name = "assurance_vie")
public class AssuranceVie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
}
