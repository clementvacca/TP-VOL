package tpVol.dao;

import java.util.List;

import tpVol.model.Vol;

public class DaoVolFactory {
	private static DaoVol singleton = null;

	public static DaoVol getInstance() {
		if (singleton == null) {
			singleton = new DaoVolJpaImpl();
		}
		return singleton;
	}
	
}
