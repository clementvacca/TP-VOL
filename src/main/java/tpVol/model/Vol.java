package tpVol.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

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
	
	@OneToMany(mappedBy="key.vol")
	private List<CompagnieAerienneVol> compagnieAerienneVol;

	@OneToOne // Un seul vol possible pour une seule réservation car cela se fait selon un
				// seul client
	@JoinColumn(name = "id_reservation")
	private Reservation reservation; // attribut relié au mappedBy dans l'autre table
	
	@OneToOne
	@JoinColumn(name="id_airport_departure")
	Aeroport aeroportDepart;
	@OneToOne
	@JoinColumn(name="id_airport_arrival")
	Aeroport aeroportArrivee;

	@OneToMany(mappedBy="key.vol")
	List<Escale> escales;// peut etre null
	@Version
	private int version;
	
	public Vol() {
	}

	public Vol(Date dateDepart, Date dateArrivee, Reservation reservation) {
		// reservation = attribut pour la liaison entre vol et reservation
		super();
		this.dateDepart = dateDepart;
		this.dateArrivee = dateArrivee;
		this.reservation = reservation;
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

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return compagnieAerienneVol;
	}

	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
	}

	public Long getIdVol() {
		return idVol;
	}

	public void setIdVol(Long idVol) {
		this.idVol = idVol;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Aeroport getAeroportDepart() {
		return aeroportDepart;
	}

	public void setAeroportDepart(Aeroport aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}

	public Aeroport getAeroportArrivee() {
		return aeroportArrivee;
	}

	public void setAeroportArrivee(Aeroport aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}

	public List<Escale> getEscales() {
		return escales;
	}

	public void setEscales(List<Escale> escales) {
		this.escales = escales;
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
