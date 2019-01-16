package tpVol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tpVol.model.CompagnieAerienne;
import tpVol.model.Reservation;
import tpVol.model.Vol;
import tpVol.util.Context;

public class DaoCompagnieAerienneJpaImpl implements DaoCompagnieAerienne {

	public List<CompagnieAerienne> findAll() {
		List<CompagnieAerienne> CompagniesAeriennes = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select r from Reservation r");
		CompagniesAeriennes = query.getResultList();
		return CompagniesAeriennes;
	}

	public CompagnieAerienne findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		CompagnieAerienne compagnieAerienne = em.find(CompagnieAerienne.class, key);
		em.close();
		return compagnieAerienne;
	}

	public void insert(CompagnieAerienne obj) {
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

	public CompagnieAerienne update(CompagnieAerienne obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienne cA=null;
		try {
			tx = em.getTransaction();
			tx.begin();
			cA=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return cA;
	}

	public void delete(CompagnieAerienne objet) {
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
			em.remove(em.find(CompagnieAerienne.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}
