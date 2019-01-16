package tpVol.dao;

public class DaoCompagnieAerienneVolFactory {
	private static DaoCompagnieAerienneVol singleton = null;

	public static DaoCompagnieAerienneVol getInstance() {
		if (singleton == null) {
			singleton = new DaoCompagnieAerienneVolJpaImpl();
		}
		return singleton;
	}

}
