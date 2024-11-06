package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalDateTime;
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

            Client client2 = new Client();
            client2.setNom("Madrigal");
            client2.setPrenom("Azul");
            client2.setAdresse(adresse1);
            client2.setBanque(banque1);

            Compte compte1 = new Compte();
            compte1.setSolde(2000.0);

            client1.setComptes(List.of(compte1));
            compte1.setClients(List.of(client1, client2));

            LivretA livretA = new LivretA();
            livretA.setTaux(5.5);
            livretA.setClients(List.of(client2));
            livretA.setSolde(850.2);

            AssuranceVie assuranceVie = new AssuranceVie();
            assuranceVie.setDateFin(LocalDate.of(2025, 6, 22));
            assuranceVie.setTaux(3.2);
            assuranceVie.setClients(List.of(client2));
            assuranceVie.setSolde(850.2);

            Operation operation1 = new Operation();
            operation1.setCompte(compte1);
            operation1.setMontant(-20.0);
            operation1.setMotif("commande uber eats");
            operation1.setDate(LocalDateTime.of(2024, 6, 22, 14, 30));

            Operation operation2 = new Operation();
            operation2.setCompte(compte1);
            operation2.setMontant(34.5);
            operation2.setMotif("Lydia");
            operation2.setDate(LocalDateTime.of(2024, 6, 25, 12, 35));

            Virement virement1 = new Virement();
            virement1.setBeneficiaire("Consuelo Diaz");
            virement1.setCompte(compte1);
            virement1.setDate(LocalDateTime.of(2024, 6, 29, 9, 5));
            virement1.setMontant(65.45);
            virement1.setMotif("cadeau anniversaire");

            compte1.setOperations(List.of(operation1, operation2, virement1));

            em.persist(banque1);
            em.persist(client1);
            em.persist(client2);
            em.persist(compte1);
            em.persist(assuranceVie);
            em.persist(livretA);
            em.persist(operation1);
            em.persist(operation2);
            em.persist(virement1);

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