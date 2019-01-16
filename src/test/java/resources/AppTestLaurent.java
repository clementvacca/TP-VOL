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
		Ville rdj=new Ville("rio de janeiro");
		Ville mar=new Ville("marseille");
		DaoVille daoVille=DaoVilleFactory.getInstance();
		daoVille.insert(par);
		daoVille.insert(rdj);
		daoVille.insert(mar);
		
		Aeroport cdg=new Aeroport("charles de gaulles",par);
		Aeroport gal=new Aeroport("galeo",rdj);
		Aeroport mari=new Aeroport("marignane",mar);
		Aeroport orl=new Aeroport("orly",par);
		DaoAeroport daoAeroport=DaoAeroportFactory.getInstance();
		
		daoAeroport.insert(cdg);
		daoAeroport.insert(gal);
		daoAeroport.insert(mari);
		daoAeroport.insert(orl);
		
		
		
		
		
		
		
		Context.close();
	}

}
