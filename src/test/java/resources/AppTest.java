package resources;

import tpVol.dao.DaoPassager;
import tpVol.dao.DaoPassagerFactory;
import tpVol.model.Adresse;
import tpVol.model.Passager;
import tpVol.util.Context;

public class AppTest {

	public static void main(String[] args) {
		DaoPassager daoPassager= DaoPassagerFactory.getInstance();
		Adresse adresse_1=new Adresse(6, "Rue rougemont", "75009", "Paris");
		Passager clement=new Passager("Vacca","Clement",adresse_1);
		
		daoPassager.insert(clement);
		clement.setNom("Schtroumpf");
		daoPassager.update(clement);
		
		Context.close();
	}

}
