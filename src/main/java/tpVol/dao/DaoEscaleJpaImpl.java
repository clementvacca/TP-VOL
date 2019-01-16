package tpVol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tpVol.model.CompagnieAerienne;
import tpVol.model.Escale;
import tpVol.util.Context;

public class DaoEscaleJpaImpl implements DaoEscale{

	public List<Escale> findAll() {
		List<Escale> escales = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select e from Escale e");
		escales = query.getResultList();
		return escales;
	}

	public Escale findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Escale escale = em.find(Escale.class, key);
		em.close();
		return escale;
	
	}

	public void insert(Escale obj) {
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

	public Escale update(Escale obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Escale es=null;
		try {
			tx = em.getTransaction();
			tx.begin();
			es=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return es;
	}

	public void delete(Escale objet) {
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
			em.remove(em.find(Escale.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		
	}

}
