package tpVol.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "vol")
@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", allocationSize = 1, initialValue = 1)
public class Vol {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVol")
	@Column(name = "no_vol", length = 150, nullable = true)
	private Long id;
	@Column(name = "date_depart", length = 150, nullable = false)
	private Date dateDepart;
	@Column(name = "date_arrivee", length = 150, nullable = false)
	private Date dateArrivee;
	@Column(name = "heure_depart", length = 150, nullable = false)
	private Date heureDepart;
	@Column(name = "heure_arrivee", length = 150, nullable = false)
	private Date heureArrivee;
	
	public Vol() {
	}

	public Vol(Long id, Date dateDepart, Date dateArrivee, Date heureDepart, Date heureArrivee) {
		super();
		this.id = id;
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.heureDepart = heureDepart;
		this.heureArrivee = heureArrivee;
	}

	public Long getId() {
		return id;
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

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
