package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import tpVol.dao.DaoPassager;
import tpVol.dao.DaoPassagerFactory;
import tpVol.dao.DaoReservation;
import tpVol.dao.DaoReservationFactory;
import tpVol.dao.DaoVol;
import tpVol.dao.DaoVolFactory;
import tpVol.model.Adresse;
import tpVol.model.Passager;
import tpVol.model.Reservation;
import tpVol.model.Vol;
import tpVol.util.Context;

public class AppTest {

	public static void main(String[] args) {
		
		// Test Client-Adresse
		DaoPassager daoPassager= DaoPassagerFactory.getInstance();
		Adresse adresse_1=new Adresse(6, "Rue rougemont", "75009", "Paris");
		Passager clement=new Passager("Vacca","Clement",adresse_1);
		
		daoPassager.insert(clement);
		
		Context.close();
	}

}
