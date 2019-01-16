package tpVol.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import tpVol.model.Client;
import tpVol.model.Login;
import tpVol.util.Context;

public class DaoClientJpaImpl implements DaoClient {

	public List<Client> findAll() {
		List<Client> c = null;
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Query query = em.createQuery("from Client c");
		c = query.getResultList();
		em.close();
		return c;
	}

	public Client findByKey(Long key) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		Client c = null;
		c = em.find(Client.class, key);
		em.close();
		return c;
	}

	public void insert(Client obj) {
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

	public Client update(Client obj) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Client c = null;
		try {
			tx = em.getTransaction();
			tx.begin();
			c = em.merge(obj);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
			if (tx != null && tx.isActive()) {
				tx.rollback();
			}
		}
		em.close();
		return c;
	}

	public void delete(Client objet) {
		EntityManager em = Context.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		Client client=null;
		Login login=null;// on créer un login pour manager cet objet
		try {
			tx = em.getTransaction();
			tx.begin();
			client =em.merge(objet);
			login=client.getLogin();//on récupère le login à supprimer via l'objet managé
			em.remove(client);
			em.remove(login);//on remove le login et le client
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
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
			em.remove(em.find(Client.class, key));
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
