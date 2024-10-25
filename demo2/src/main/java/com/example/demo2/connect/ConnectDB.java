package com.example.demo2.connect;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ConnectDB {
    private static ConnectDB instance;
    EntityManager em;

    public ConnectDB() {
        em = Persistence.createEntityManagerFactory("default").createEntityManager();
    }

    public static ConnectDB getInstance() {
        if (instance == null) {
            instance = new ConnectDB();
        }
        return instance;
    }

    public EntityManager getEntityManager() {
        return em;
    }

    public static void main(String[] args) {
        ConnectDB.getInstance().getEntityManager();
    }
}
