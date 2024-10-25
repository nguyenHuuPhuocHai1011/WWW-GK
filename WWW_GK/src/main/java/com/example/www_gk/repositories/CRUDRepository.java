package com.example.www_gk.repositories;

import com.example.www_gk.repositories.instance.ConnectDB;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;

import java.util.List;
import java.util.Optional;

public class CRUDRepository<T> {
    protected final EntityManager entityManager;
    protected final EntityTransaction transaction;

    public CRUDRepository() {
        entityManager = ConnectDB.getInstance().getEntityManager();
        transaction = entityManager.getTransaction();
    }

    public List<T> getAll(Class<T> clazz) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(clazz);
        query.from(clazz);
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        return typedQuery.getResultList();
    }

    public Optional<T> get(Class<T> clazz, Long id) {
        T obj = entityManager.find(clazz, id);
        return obj != null ? Optional.of(obj) : Optional.empty();
    }

    public boolean insert(T obj) {
        try {
            transaction.begin();
            entityManager.persist(obj);
            transaction.commit();
            return true;
        }catch (Exception e) {
            transaction.rollback();
            return false;
        }
    }

    public boolean update(T obj) {
        try {
            transaction.begin();
            entityManager.merge(obj);
            transaction.commit();
            return true;
        }catch (Exception e) {
            transaction.rollback();
            return false;
        }
    }

    public boolean delete(T obj) {
        try {
            transaction.begin();
            entityManager.remove(obj);
            transaction.commit();
            return true;
        }catch (Exception e) {
            transaction.rollback();
            return false;
        }
    }
}
