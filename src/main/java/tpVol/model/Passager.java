package tpVol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "passager")
@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", allocationSize = 1, initialValue = 100)
public class Passager {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@Column(name = "id_passager", length = 50, nullable = false)
	private Long id;
	@Column(name = "nom_passager", length = 50, nullable = false)
	private String nom;
	@Column(name = "prenom_passager", length = 50, nullable = false)
	private String prenom;
	@Column(name = "adresse", length = 150, nullable = true)
	private Adresse adresse;
	
	@Version
	private int version;

	
	
	
	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passager(String nom, String prenom, Adresse adresse) {
		this.nom=nom;
		this.prenom=prenom;
		this.adresse=adresse;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	

}
