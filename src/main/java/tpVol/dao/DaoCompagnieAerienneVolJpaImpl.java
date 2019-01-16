package tpVol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tpVol.model.CompagnieAerienneVol;
import tpVol.model.CompagnieAerienneVolPk;
import tpVol.util.Context;

public class DaoCompagnieAerienneVolJpaImpl implements DaoCompagnieAerienneVol {

	public List<CompagnieAerienneVol> findAll() {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		List<CompagnieAerienneVol> cav = null;
		Query query = em.createQuery("from CompagnieAerienneVol c");
		cav = query.getResultList();
		em.close();
		return cav;
	}

	public CompagnieAerienneVol findByKey(CompagnieAerienneVolPk key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		CompagnieAerienneVol cav = null;
		cav = em.find(CompagnieAerienneVol.class, key);
		em.close();
		return cav;
	}

	public void insert(CompagnieAerienneVol obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.persist(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public CompagnieAerienneVol update(CompagnieAerienneVol obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		CompagnieAerienneVol cav = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			cav = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return cav;
	}

	public void delete(CompagnieAerienneVol objet) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.merge(objet));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public void deleteByKey(CompagnieAerienneVolPk key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(CompagnieAerienneVol.class, key));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

}
