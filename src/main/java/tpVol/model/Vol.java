package tpVol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", allocationSize = 1, initialValue = 1)
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	@Column(name = "no_vol", length = 150, nullable = true)
	private Long idVol;
	@Column(name = "date_depart", length = 150, nullable = false)
	private Date dateDepart;
	@Column(name = "date_arrivee", length = 150, nullable = false)
	private Date dateArrivee;

	@OneToOne // Un seul vol possible pour une seule réservation car cela se fait selon un seul client 
	@JoinColumn(name="id_reservation")
	private Reservation reservation;
	
	public Vol() {
	}

	public Vol(Date dateDepart, Date dateArrivee) {
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
	}

	public Long getId() {
		return idVol;
	}

	public Date getDateDepart() {
		return dateDepart;
	}

	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}

	public Date getDateArrivee() {
		return dateArrivee;
	}

	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVol == null) ? 0 : idVol.hashCode());
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
		Vol other = (Vol) obj;
		if (idVol == null) {
			if (other.idVol != null)
				return false;
		} else if (!idVol.equals(other.idVol))
			return false;
		return true;
	}

}
