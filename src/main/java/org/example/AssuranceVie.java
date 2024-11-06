package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity
public class AssuranceVie extends Compte {
    @Column(name = "date_fin")
    private LocalDate dateFin;

    @Column(name = "taux")
    double taux;

    public AssuranceVie(){}

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public double getTaux() {
        return taux;
    }

    public void setTaux(double taux) {
        this.taux = taux;
    }

//    @Override
//    public List<Client> getClients() {
//        return super.getClients();
//    }
//
//    @Override
//    public void setClients(List<Client> clients) {
//        super.setClients(clients);
//    }
//
//    @Override
//    public Double getSolde() {
//        return super.getSolde();
//    }
//
//    @Override
//    public void setSolde(Double solde) {
//        super.setSolde(solde);
//    }
}
