package tpVol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="reservation")
@SequenceGenerator(name = "seqReservation", sequenceName = "seq_reservation", allocationSize = 1, initialValue = 1)
public class Reservation {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqReservation")
	@Column(name="id_reservation", length=20, nullable=true)
	private Long idReservation;
	@Column(name="date_reservation", length=20, nullable=true)
	private Date dateReservation;
	@Column(name="numero_reservation", length=20, nullable=true)
	private Integer numeroReservation;
	
	@ManyToOne // Plusieurs r�servations possibles pour un seul passager 
	@JoinColumn(name="id_passager")
	private Passager passager;
	
	@OneToOne // Une seule r�servation pour un seul vol car cela se fait selon un seul client (qui ne r�serve qu'une place)
	@JoinColumn(name="no_vol")
	private Vol vol;
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idReservation == null) ? 0 : idReservation.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Reservation other = (Reservation) obj;
		if (idReservation == null) {
			if (other.idReservation != null)
				return false;
		} else if (!idReservation.equals(other.idReservation))
			return false;
		return true;
	}
	
}
