package com.bookstore.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class JpaDAO<E> {

    protected EntityManager entityManager;

    public JpaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public E create(E entity) {
        entityManager.getTransaction().begin();
        entityManager.persist(entity);
        entityManager.flush();
        entityManager.refresh(entity);
        entityManager.getTransaction().commit();
        return entity;
    }

       
    
    public E update(E entity) {
        entityManager.getTransaction().begin();
        E updatedEntity = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return updatedEntity;
    }

    public E find(Class<E> type , Object id) {
    	
    	E entity = entityManager.find(type, id);
    	if(entity != null) {
    	entityManager.refresh(entity);
    	}
    	return entity;
    }
    
    
    
    public E get(Object id) {
        return entityManager.find(getEntityClass(), id);
    }

//    public void delete(Object id) {
//        entityManager.getTransaction().begin();
//        E entity = entityManager.find(getEntityClass(), id);
//        if (entity != null) {
//            entityManager.remove(entity);
//        }
//        entityManager.getTransaction().commit();
//    }

    public List<E> listAll() {
        String jpql = "SELECT e FROM " + getEntityClass().getSimpleName() + " e";
        return entityManager.createQuery(jpql, getEntityClass()).getResultList();
    }

    public long count() {
        String jpql = "SELECT COUNT(e) FROM " + getEntityClass().getSimpleName() + " e";
        return entityManager.createQuery(jpql, Long.class).getSingleResult();
    }

    protected Class<E> getEntityClass() {
        throw new UnsupportedOperationException("Subclasses must implement getEntityClass() method");
    }
    
    public void delete(Class<E> type , Object id)
    {
    	entityManager.getTransaction().begin();
    	    	
    	Object 	reference = entityManager.getReference(type, id);
    	
    	entityManager.remove(reference);
    	
    	entityManager.getTransaction().commit();
    	
    }
    
    public List<E> findWithNamedQuery(String queryName)
    {
    	
    	Query query = entityManager.createNamedQuery(queryName);
    	return query.getResultList();
    	
    }
    
    public List<E> findWithNamedQuery(String queryName, String paramNam , Object paramValue){
    	
    	
    	Query query = entityManager.createNamedQuery(queryName);
    	query.setParameter(paramNam, paramValue);
    	return query.getResultList();
    }
    
    
    
    public long countWithNamedQuery(String  queryName)
    {
    	
    	Query query = entityManager.createNamedQuery(queryName);
    	return (long) query.getSingleResult();
    	
    }
}
