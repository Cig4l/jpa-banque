package org.example;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // Utilisez AUTO pour TABLE_PER_CLASS
    private Integer id;

    @Temporal(TemporalType.TIMESTAMP) // Spécifie le type temporel pour la date
    @Column(name = "date")
    private LocalDateTime date;

    @Column(name = "montant")
    private Double montant;

    @Column(name = "motif")
    private String motif;

    @ManyToOne
    @JoinColumn(name = "id_compte")
    private Compte compte;

    public Operation() {}

    // Getters et Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }
}