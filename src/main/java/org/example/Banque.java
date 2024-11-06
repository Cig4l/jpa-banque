package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="banque")
public class Banque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="nom")
    private String nom;

    @OneToMany(mappedBy = "banque", cascade = CascadeType.ALL)
    private List<Client> clients;

    public  Banque(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
