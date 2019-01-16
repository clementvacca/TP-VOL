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
		reservation1.setNumeroReservation(44444444);
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		try {
			reservation1.setDateReservation(sdf1.parse("25/11/2018 08:35:24"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Reservation reservation2 = new Reservation();
		reservation2.setNumeroReservation(5555555);
		SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		try {
			reservation2.setDateReservation(sdf3.parse("26/11/2018 08:35:24"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		Reservation reservation3 = new Reservation();
		reservation3.setNumeroReservation(7777777);
		SimpleDateFormat sdf4 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		try {
			reservation3.setDateReservation(sdf4.parse("24/11/2018 08:35:24"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		DaoReservation daoReservation = DaoReservationFactory.getInstance();
		daoReservation.insert(reservation1);
		daoReservation.insert(reservation2);
		daoReservation.insert(reservation3);
		
		Vol vol1 = new Vol();
		vol1.setReservation(reservation1);
		DaoVol daoVol = DaoVolFactory.getInstance();
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy kk:mm:ss");
		try {
			vol1.setDateDepart(sdf2.parse("29/08/2019 21:30:00"));
			vol1.setDateArrivee(sdf2.parse("30/08/2019 08:00:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		daoVol.insert(vol1);
		
						
		
	}

}
