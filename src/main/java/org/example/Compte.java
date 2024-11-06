package org.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="compte")
public class Compte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @Column(name="solde")
    Double solde;

    @ManyToMany(mappedBy = "comptes")
    private List<Client> clients;

    @OneToMany(mappedBy = "compte")
    private List<Operation> operations;

    public Compte(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
