package tpVol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name="compagnieAerienne")
@SequenceGenerator(name = "seqCompagnieAerienne", sequenceName = "seq_compagnie_aerienne", allocationSize = 1, initialValue = 1)
public class CompagnieAerienne {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCompagnieAerienne")
	@Column(name="id_compagnie_aerienne")
	private Long idCompagnieAerienne;
	@Column(name="nom_compagnie_aerienne")
	private String nomCompagnieAerienne;
	
	@OneToMany
	private List<CompagnieAerienneVol> compagnieAerienneVol;
	
	@Version
	private int version;
	
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

	public Long getIdCompagnieAerienne() {
		return idCompagnieAerienne;
	}

	public void setIdCompagnieAerienne(Long idCompagnieAerienne) {
		this.idCompagnieAerienne = idCompagnieAerienne;
	}

	public List<CompagnieAerienneVol> getCompagnieAerienneVol() {
		return compagnieAerienneVol;
	}

	public void setCompagnieAerienneVol(List<CompagnieAerienneVol> compagnieAerienneVol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}
	
}
