package org.example;


import jakarta.persistence.*;

import java.util.List;

@Entity
public class LivretA extends Compte {
    @Column(name = "taux")
    private Double taux;

    public LivretA(){}

    public Double getTaux() {
        return taux;
    }

    public void setTaux(Double taux) {
        this.taux = taux;
    }
}
