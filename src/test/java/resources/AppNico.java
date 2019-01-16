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
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		try {
			reservation1.setDateReservation(sdf1.parse("24/11/2018 08:35:24"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DaoReservation daoReservation = DaoReservationFactory.getInstance();
		daoReservation.insert(reservation1);
		
		Vol vol1 = new Vol();
		DaoVol daoVol = DaoVolFactory.getInstance();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
		try {
			vol1.setDateDepart(sdf2.parse("29/08/2019"));
			vol1.setDateArrivee(sdf2.parse("30/08/2019"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		SimpleDateFormat sdf3 = new SimpleDateFormat("kk:mm:ss");
		try {
			vol1.setDateDepart(sdf3.parse("21:30:00"));
			vol1.setDateArrivee(sdf3.parse("08:00:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		daoVol.insert(vol1);
				
		
	}

}
