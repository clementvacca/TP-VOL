package tpVol.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private Long id_passager;
	@Column(name = "nom_passager", length = 50, nullable = false)
	private String nom_passager;
	@Column(name = "prenom_passager", length = 50, nullable = false)
	private String prenom_passager;
	@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="numero",column=@Column(name="number")),
		@AttributeOverride(name="rue",column=@Column(name="street",length=150)),
		@AttributeOverride(name="cp",column=@Column(name="zip_code", length=5)),
		@AttributeOverride(name="ville",column=@Column(name="city",length=150))
	})
	private Adresse adresse;
	@OneToMany(mappedBy="passager",fetch=FetchType.LAZY)
	private Set<Reservation> reservations;
	
	
	@Version
	private int version;
	
	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Passager(String nom, String prenom, Adresse adresse) {
		this.nom_passager=nom;
		this.prenom_passager=prenom;
		this.adresse=adresse;
	}

	public Long getId() {
		return id_passager;
	}

	public void setId(Long id) {
		this.id_passager = id;
	}

	public String getNom() {
		return nom_passager;
	}

	public void setNom(String nom) {
		this.nom_passager = nom;
	}

	public String getPrenom() {
		return prenom_passager;
	}

	public void setPrenom(String prenom) {
		this.prenom_passager = prenom;
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
