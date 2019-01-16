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

@Entity
@Table(name = "city")
@SequenceGenerator(name = "seqVille", sequenceName = "seq_city", allocationSize = 1, initialValue = 1)
public class Ville {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqVille")
	@Column(name = "id_city", length = 150, nullable = false)
	private Long idVille;
	@Column(name = "name_city", length = 150, nullable = false)
	private String nomVille;
	@OneToMany(mappedBy="ville")
	private List<Aeroport> aeroports;
	
	public Ville(String nomVille) {
		super();
		this.nomVille = nomVille;
	}
	
	public Ville() {
		
	}

	public Long getIdVille() {
		return idVille;
	}

	
	public String getNomVille() {
		return nomVille;
	}

	public void setNomVille(String nomVille) {
		this.nomVille = nomVille;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idVille == null) ? 0 : idVille.hashCode());
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
		Ville other = (Ville) obj;
		if (idVille == null) {
			if (other.idVille != null)
				return false;
		} else if (!idVille.equals(other.idVille))
			return false;
		return true;
	}
	
	
	
	
}
