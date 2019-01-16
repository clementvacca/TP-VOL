package tpVol.dao;

import java.util.List;

import tpVol.model.Passager;

public interface DaoPassager extends DaoGeneric<Passager, Long> {
	
	public Passager findByKeyWithReservation(Long key);
	public List<Passager> findAllPassagersWithReservation();
}
