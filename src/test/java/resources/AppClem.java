package resources;

import tpVol.dao.DaoClient;
import tpVol.dao.DaoClientFactory;
import tpVol.dao.DaoLogin;
import tpVol.dao.DaoLoginFactory;
import tpVol.dao.DaoPassager;
import tpVol.dao.DaoPassagerFactory;
import tpVol.model.Adresse;
import tpVol.model.ClientPhysique;
import tpVol.model.Login;
import tpVol.model.Passager;
import tpVol.util.Context;

public class AppClem {

	public static void main(String[] args) {
		
		// Test Client-Adresse
		DaoPassager daoPassager= DaoPassagerFactory.getInstance();
		Adresse adresse_1=new Adresse(6, "Rue rougemont", "75009", "Paris");
		Passager clement=new Passager("Vacca","Clement",adresse_1);
		
		daoPassager.insert(clement);
		
		DaoLogin daoLogin=DaoLoginFactory.getInstance();
		DaoClient daoClient=DaoClientFactory.getInstance();
		
		ClientPhysique client=new ClientPhysique("Vacca", "0156230451", "0515415", "clem@mail.com", adresse_1);
		Login login=new Login("clemvac", "lool", false);
		client.setLogin(login);
		daoLogin.insert(login);
		login.setAdmin(true);
		daoLogin.update(login);
		daoLogin.delete(login);
		daoClient.insert(client);
		
		
		
		
		Context.close();
	}

}
