package tpVol.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne // Plusieurs réservations possibles pour un seul passager 
	@JoinColumn(name="id_passager")
	private Passager passager;
	
	@OneToMany(mappedBy="reservation") // Une seule réservation pour plusieurs vol
	private List<Vol> vol;
	
	@ManyToOne
	@JoinColumn(name="id_client")
	private Client client;
	
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
	
	
	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Passager getPassager() {
		return passager;
	}

	public void setPassager(Passager passager) {
		this.passager = passager;
	}

	public List<Vol> getVol() {
		return vol;
	}

	public void setVol(List<Vol> vol) {
		this.vol = vol;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
