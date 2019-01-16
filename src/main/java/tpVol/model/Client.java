package tpVol.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "client")
@SequenceGenerator(name = "seqClient",sequenceName = "seq_client", allocationSize = 20, initialValue = 100)
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="titre",length=1)
public abstract class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@Column(name = "id_client")
	private Long idClient;
	@Column(name = "nom_client")
	private String nom;
	@Column(name = "numero_tel")
	private Integer numeroTel;
	@Column(name = "numero_fax")
	private Integer numeroFax;
	@Column(name = "email_client")
	private String email;
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "numero_rue")),
		@AttributeOverride(name = "rue", column = @Column(name = "rue", length = 150)),
		@AttributeOverride(name = "cp", column = @Column(name = "code_postal", length = 5)),
		@AttributeOverride(name = "ville", column = @Column(name = "ville", length = 150)) })
	private Adresse adresse;
	
	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(Long idClient, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse) {
		this.idClient = idClient;
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
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

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idClient == null) ? 0 : idClient.hashCode());
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
		Client other = (Client) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idClient == null) {
			if (other.idClient != null)
				return false;
		} else if (!idClient.equals(other.idClient))
			return false;
		return true;
	}
	
	
	
	
	
	
	

}
