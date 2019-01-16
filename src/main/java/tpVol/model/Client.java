package tpVol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import objets.Article;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", allocationSize = 1, initialValue = 1)
public abstract class  Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "no_client", length = 150, nullable = true)
	private Long id;
	@Column(name = "name", length = 150, nullable = false)
	private String nom;
	@Column(name = "numero_tel", length = 150, nullable = true)
	private Integer numeroTel;
	@Column(name = "numero_fax", length = 150, nullable = true)
	private Integer numeroFax;
	@Column(name = "email", length = 150, nullable = true)
	private String email;
	//@OneToMany(mappedBy="client")
	//private List<Reservation> reservations;
	
	
	public Client(String nom, Integer numeroTel, Integer numeroFax, String email) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
	}
	public Client() {
		
	}
	public Long getId() {
		return id;
	}
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Integer getNumeroTel() {
		return numeroTel;
	}
	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}
	public Integer getNumeroFax() {
		return numeroFax;
	}
	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	
}
