package tpVol.dao;

public class DaoEscaleFactory {
	private static DaoEscale singleton = null;

	public static DaoEscale getInstance() {
		if (singleton == null) {
			singleton = new DaoEscaleJpaImpl();
		}
		return singleton;
	}
}
