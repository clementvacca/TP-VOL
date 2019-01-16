package tpVol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="Compagnie_aerienne")
@SequenceGenerator(name = "seqCompagnieAerienne", sequenceName = "seq_compagnie_aerienne", allocationSize = 1, initialValue = 1)
public class CompagnieAerienne {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnieAerienne")
	@Column(name="id_compagnie_aerienne")
	private Long idCompagnieAerienne;
	@Column(name="nom_compagnie_aerienne")
	private String nomCompagnieAerienne;
	
	public CompagnieAerienne() {
	}

	public CompagnieAerienne(String nomCompagnieAerienne) {
		super();
		this.nomCompagnieAerienne = nomCompagnieAerienne;
	}

	public String getNomCompagnieAerienne() {
		return nomCompagnieAerienne;
	}

	public void setNomCompagnieAerienne(String nomCompagnieAerienne) {
		this.nomCompagnieAerienne = nomCompagnieAerienne;
	}
	
}
