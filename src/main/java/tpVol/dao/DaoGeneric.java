package tpVol.dao;

import java.util.List;

import tpVol.model.Passager;

public interface DaoGeneric<T, K> {
	public List<T> findAll(); // on récupère un type générique

	public T findByKey(K key);

	public void insert(T obj);

	public T update(T obj);

	public void delete(T objet);

	public void deleteByKey(K key);


}
