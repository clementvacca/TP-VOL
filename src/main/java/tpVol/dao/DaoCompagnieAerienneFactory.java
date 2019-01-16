package tpVol.dao;

public class DaoCompagnieAerienneFactory {
	private static DaoCompagnieAerienne singleton = null;

	public static DaoCompagnieAerienne getInstance() {
		if (singleton == null) {
			singleton = new DaoCompagnieAerienneJpaImpl();
		}
		return singleton;
	}
	
}
