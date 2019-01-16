package tpVol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("p") 
public class ClientPhysique extends Client{
	@Column(name="first_name")
	private String prenom;
	@Enumerated(EnumType.STRING)
	private TitrePhysique titrePhysique;
	
	
	public ClientPhysique() {
		super();
	}

	public ClientPhysique(String nom, String numeroTel, String numeroFax, String email, Adresse adresse) {
		super(nom, numeroTel, numeroFax, email, adresse);
		// TODO Auto-generated constructor stub
	}

	public ClientPhysique(String nom, String numeroTel, String numeroFax, String email, Adresse adresse, String prenom, TitrePhysique titrePhysique) {
		super(nom, numeroTel, numeroFax, email, adresse);
		this.prenom = prenom;
		this.titrePhysique = titrePhysique;
	}

	

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public TitrePhysique getTitrePhysique() {
		return titrePhysique;
	}

	public void setTitrePhysique(TitrePhysique titrePhysique) {
		this.titrePhysique = titrePhysique;
	}

}
