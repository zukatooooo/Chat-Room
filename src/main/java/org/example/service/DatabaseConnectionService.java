package org.example.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.example.model.ChatRoom;

import java.util.List;

public class DatabaseConnectionService {
    private static DatabaseConnectionService databaseConnectionServiceObject = null;

    public DatabaseConnectionService() {
    }

    public static DatabaseConnectionService instance() {
        if(databaseConnectionServiceObject == null) {
            databaseConnectionServiceObject = new DatabaseConnectionService();
        }
        return databaseConnectionServiceObject;
    }

    public void getDataFromDatabase() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("my-unit");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ChatRoom> criteriaQuery = criteriaBuilder.createQuery(ChatRoom.class);
        Root<ChatRoom> root = criteriaQuery.from(ChatRoom.class);

        criteriaQuery.select(root);
        TypedQuery<ChatRoom> query = entityManager.createQuery(criteriaQuery);
        List<ChatRoom> chatRooms = query.getResultList();

        for (ChatRoom chatRoom : chatRooms) {
            System.out.println("ChatRoom ID: " + chatRoom.getId());
            System.out.println("ChatRoom Name: " + chatRoom.getName());
            System.out.println("ChatRoom Capacity: " + chatRoom.getMaxCapacity());
        }

        entityManager.close();
        entityManagerFactory.close();
    }
}
