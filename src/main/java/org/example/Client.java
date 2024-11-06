package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom")
    private String nom;

    @Column(name="prenom")
    private String prenom;

    @ManyToOne
    @JoinColumn(name = "id_banque")
    private Banque banque;

    @ManyToMany
    @JoinTable(
            name = "client_compte",
            joinColumns = @JoinColumn(name = "client_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "compte_id", referencedColumnName = "id")
    )
    private List<Compte> comptes;

    @Embedded
    private Adresse adresse;

    public Client(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
}
