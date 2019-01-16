package resources;

import tpVol.dao.DaoAeroport;
import tpVol.dao.DaoAeroportFactory;
import tpVol.dao.DaoVille;
import tpVol.dao.DaoVilleFactory;
import tpVol.model.Aeroport;
import tpVol.model.Ville;
import tpVol.util.Context;

public class AppTestLaurent {

	public static void main(String[] args) {
		Ville par=new Ville("paris");
		DaoVille daoVille=DaoVilleFactory.getInstance();
		daoVille.insert(par);
		Aeroport cdg=new Aeroport("charles de gaulles",par);
		DaoAeroport daoAeroport=DaoAeroportFactory.getInstance();
		
		daoAeroport.insert(cdg);
		
		
		
		
		
		
		
		Context.close();
	}

}
