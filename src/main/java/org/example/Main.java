package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import java.util.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("myPersistenceUnit");
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            Banque banque1 = new Banque();
            banque1.setNom("CIC Iberbanco");

            Adresse adresse1 = new Adresse();
            adresse1.setNumero(26);
            adresse1.setRue("rue des Aubépines");
            adresse1.setCodePostal(66000);
            adresse1.setVille("Perpignan");

            Client client1 = new Client();
            client1.setNom("Madrigal");
            client1.setPrenom("Maria");
            client1.setAdresse(adresse1);
            client1.setBanque(banque1);

            Compte compte1 = new Compte();
            compte1.setSolde(2000.0);

            Operation operation1 = new Operation();
            operation1.setCompte(compte1);
            operation1.setMontant(20.0);
            operation1.setMotif("commande uber eats");
            operation1.setDate(new Date());

            client1.setComptes(List.of(compte1));
            compte1.setClients(List.of(client1));

            em.persist(banque1);
            em.persist(client1);
            em.persist(compte1);
            em.persist(operation1);

            transaction.commit();

            Client client = em.find(Client.class, 1);
            if (client != null) {
                System.out.println("Client trouvé : " + client.getPrenom() + " " + client.getNom());
            } else {
                System.out.println("Aucun client trouvé avec l'ID 1");
            }
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}