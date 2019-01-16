package tpVol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tpVol.model.Aeroport;
import tpVol.model.Passager;
import tpVol.model.Vol;
import tpVol.util.Context;

public class DaoAeroportJpaImpl implements DaoAeroport{

	public List<Aeroport> findAll() {
		List<Aeroport> aeroports = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Aeroport a"); //"from Personne p" fonctionne aussi
		aeroports=query.getResultList();
		em.close();
		return aeroports;
	}

	public Aeroport findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Aeroport a = null;
		a = em.find(Aeroport.class, key);
		em.close();
		return a;
	}

	public void insert(Aeroport obj) {
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

	public Aeroport update(Aeroport obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Aeroport a=null;
		try {
			tx = em.getTransaction();
			tx.begin();
			a=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return a;
	}

	public void delete(Aeroport objet) {
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
			em.remove(em.find(Aeroport.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}


