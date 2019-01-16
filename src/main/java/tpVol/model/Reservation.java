package tpVol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", allocationSize = 1, initialValue = 1)
public class Reservation {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name="id_reservation")
	private Long idReservation;
	@Column(name="date_reservation")
	private Date dateReservation;
	@Column(name="numero_reservation")
	private Integer numeroReservation;
	
	@ManyToOne
	@JoinColumn(name="id_passager")
	private Passager passager;
	
	public Reservation() {
	}

	public Reservation(Date dateReservation, Integer numeroReservation) {
		super();
		this.dateReservation = dateReservation;
		this.numeroReservation = numeroReservation;
	}

	public Date getDateReservation() {
		return dateReservation;
	}


	public void setDateReservation(Date dateReservation) {
		this.dateReservation = dateReservation;
	}


	public Integer getNumeroReservation() {
		return numeroReservation;
	}


	public void setNumeroReservation(Integer numeroReservation) {
		this.numeroReservation = numeroReservation;
	}
	
}
