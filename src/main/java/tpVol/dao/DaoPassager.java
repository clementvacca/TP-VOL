package tpVol.dao;

import java.util.List;

import tpVol.model.Passager;

public interface DaoPassager extends DaoGeneric<Passager, Integer> {
	
	public Passager findByKeyWithReservation(Integer key);
	public List<Passager> findAllPassagersWithReservation();
}
