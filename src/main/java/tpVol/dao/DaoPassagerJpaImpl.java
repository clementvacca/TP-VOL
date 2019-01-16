package tpVol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tpVol.model.Passager;
import tpVol.util.Context;


public class DaoPassagerJpaImpl implements DaoPassager {

	@SuppressWarnings("unchecked") 
	public List<Passager> findAll() {
		List<Passager> passagers = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("select a from Adherent a"); //"from Personne p" fonctionne aussi
		passagers=query.getResultList();
		em.close();
		return passagers;
	}

	public Passager findByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Passager p = null;
		p = em.find(Passager.class, key);
		em.close();
		return p;
	}

	public void insert(Passager obj) {
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

	public Passager update(Passager obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Passager p=null;
		try {
			tx = em.getTransaction();
			tx.begin();
			p=em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return p;
	}

	public void delete(Passager objet) {
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

	public void deleteByKey(Integer key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			em.remove(em.find(Passager.class, key));
			tx.commit();
		} catch (Exception e) {
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
	}

	public Passager findByKeyWithReservation(Integer key){
		Passager adherent=null;
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("select p from Passager p left join fetch p.reservations where p.id=:key");
		query.setParameter("key", key);
		adherent=(Passager) query.getSingleResult();
		em.close();
		return adherent;
	}

	public List<Passager> findAllPassagersWithReservation() {
		List<Passager> reservations=null;
		EntityManager em=Context.getEntityManagerFactory().createEntityManager();
		Query query=em.createQuery("select p from Passager p left join fetch p.reservations");
		reservations=query.getResultList();
		em.close();
		return reservations;
	}
}
