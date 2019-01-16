package tpVol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tpVol.model.Login;
import tpVol.util.Context;

public class DaoLoginJpaImpl implements DaoLogin {

	public List<Login> findAll() {
		List<Login> logins = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select l from Login l"); //"from Personne p" fonctionne aussi
		logins=query.getResultList();
		em.close();
		return logins;
	}

	public Login findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Login l = null;
		l = em.find(Login.class, key);
		em.close();
		return l;
	}

	public void insert(Login obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public Login update(Login obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Login l=null;
		try {
			tx = em.getTransaction();
			tx.begin();
			l=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return l;
	}

	public void delete(Login objet) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(objet));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public void deleteByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Login.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}
