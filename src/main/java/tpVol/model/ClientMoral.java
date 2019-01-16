package tpVol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("m")
public class ClientMoral extends Client {
	@Column(name="siret")
	private String siret;
	@Enumerated(EnumType.STRING)
	private TitreMoral titre_moral;
	
	public ClientMoral() {
		super();
	}

	public ClientMoral(String nom, String numeroTel, String numeroFax, String email, Adresse adresse) {
		super(nom, numeroTel, numeroFax, email, adresse);
		// TODO Auto-generated constructor stub
	}
	public ClientMoral(String nom, String numeroTel, String numeroFax, String email, Adresse adresse,String siret, TitreMoral titre) {
		super(nom, numeroTel, numeroFax, email, adresse);
		this.siret = siret;
		this.titre_moral = titre;
	}
	public ClientMoral(String siret, TitreMoral titre) {
		super();
		this.siret = siret;
		this.titre_moral = titre;
	}

	public String getPrenom() {
		return siret;
	}

	public void setPrenom(String prenom) {
		this.siret = prenom;
	}

	public TitreMoral getTitre() {
		return titre_moral;
	}

	public void setTitre(TitreMoral titre) {
		this.titre_moral = titre;
	}
	
	

}
