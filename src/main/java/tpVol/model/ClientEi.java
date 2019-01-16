package tpVol.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
@DiscriminatorValue("e") 
public class ClientEi extends Client{
	@Column(name="prenom")
	private String prenom;
	@Enumerated(EnumType.STRING)
	private TitrePhysique titrePhysique;
	
	public ClientEi() {
		// TODO Auto-generated constructor stub
	}

	public ClientEi(String prenom, TitrePhysique titre) {
		this.prenom = prenom;
		this.titrePhysique = titre;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public TitrePhysique getTitre() {
		return titrePhysique;
	}

	public void setTitre(TitrePhysique titre) {
		this.titrePhysique = titre;
	}
	
	
	
	

}
