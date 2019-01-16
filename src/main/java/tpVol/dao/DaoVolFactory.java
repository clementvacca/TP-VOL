package tpVol.dao;

public class DaoVolFactory {
	private static DaoVol singleton = null;

	public static DaoVol getInstance() {
		if (singleton == null) {
			singleton = new DaoVolJpaImpl();
		}
		return singleton;
	}
	
}
