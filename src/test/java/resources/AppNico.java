package resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import tpVol.dao.DaoReservation;
import tpVol.dao.DaoReservationFactory;
import tpVol.dao.DaoVol;
import tpVol.dao.DaoVolFactory;
import tpVol.model.Reservation;
import tpVol.model.Vol;

public class AppNico {

	public static void main(String[] args) {
		// Test Reservation-Vol
		Reservation reservation1 = new Reservation();
		reservation1.setNumeroReservation(41445882);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			reservation1.setDateReservation(sdf.parse("24/11/2018"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Vol vol1 = new Vol();
		DaoVol daoVol = DaoVolFactory.getInstance();
		daoVol.insert(vol1);
				
		DaoReservation daoReservation = DaoReservationFactory.getInstance();
		daoReservation.insert(reservation1);
	}

}
