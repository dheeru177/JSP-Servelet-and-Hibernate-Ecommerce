package com.bookstore.dao;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JpaDAO<E> {

	private static EntityManagerFactory entityManagerFactory;

	static {

		entityManagerFactory = Persistence.createEntityManagerFactory("BookStoreWebsitee");

	}

	public JpaDAO() {

	}

	public E create(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.flush();
		entityManager.refresh(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return entity;
	}

	public E update(E entity) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();
		E updatedEntity = entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
		return updatedEntity;
	}

	public E find(Class<E> type, Object id) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		E entity = entityManager.find(type, id);
		if (entity != null) {
			entityManager.refresh(entity);
		}
		entityManager.close();
		return entity;
	}

	public E get(Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.close();
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
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "SELECT e FROM " + getEntityClass().getSimpleName() + " e";
		entityManager.close();
		return entityManager.createQuery(jpql, getEntityClass()).getResultList();
	}

	public long count() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String jpql = "SELECT COUNT(e) FROM " + getEntityClass().getSimpleName() + " e";
		entityManager.close();
		return entityManager.createQuery(jpql, Long.class).getSingleResult();
	}

	protected Class<E> getEntityClass() {
		throw new UnsupportedOperationException("Subclasses must implement getEntityClass() method");
	}

	public void delete(Class<E> type, Object id) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		Object reference = entityManager.getReference(type, id);

		entityManager.remove(reference);

		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public List<E> findWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);

		List<E> result = query.getResultList();
		entityManager.close();
		return result;

	}

	public List<E> findWithNamedQuery(String queryName, int firstResult, int maxResult) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setFirstResult(firstResult);
		query.setMaxResults(maxResult);

		List<E> result = query.getResultList();
		entityManager.close();
		return result;

	}

	public List<E> findWithNamedQuery(String queryName, String paramNam, Object paramValue) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		query.setParameter(paramNam, paramValue);
		List<E> result = query.getResultList();
		entityManager.close();
		return result;
	}

	public List<E> findWithNamedQuery(String queryName, Map<String, Object> parameters) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
		Set<Entry<String, Object>> setParameters = parameters.entrySet();
		for (Entry<String, Object> entry : setParameters) {

			query.setParameter(entry.getKey(), entry.getValue());

		}

		List<E> result = query.getResultList();
		entityManager.close();
		return result;
	}

	public long countWithNamedQuery(String queryName) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);

		long result = (long) query.getSingleResult();
		entityManager.close();
		return result;

	}
	public long countWithNamedQuery(String queryName, String paramName , Object paramValue) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Query query = entityManager.createNamedQuery(queryName);
        query.setParameter(paramName, paramValue);
		long result = (long) query.getSingleResult();
		entityManager.close();
		return result;

	}
	public void close()
	{
		if(entityManagerFactory != null) {
		entityManagerFactory.close();
		}
	}
}
