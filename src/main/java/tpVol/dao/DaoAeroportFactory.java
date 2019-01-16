package tpVol.dao;

public class DaoAeroportFactory {
	private static DaoAeroport singleton = null;

	public static DaoAeroport getInstance() {
		if (singleton == null) {
			singleton = new DaoAeroportJpaImpl();
		}
		return singleton;
	}
	

}
