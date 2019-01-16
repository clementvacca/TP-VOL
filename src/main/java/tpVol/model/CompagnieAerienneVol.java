package tpVol.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(name = "compagnie_aerienne_vol")
public class CompagnieAerienneVol {
	
	@EmbeddedId
	private CompagnieAerienneVolPk key;
	
	@Column(name = "numero_vol_pk", length = 50)
	private String numero;
	
	@Version
	private int version;
	
	public CompagnieAerienneVol() {
		// TODO Auto-generated constructor stub
	}

	public CompagnieAerienneVol(CompagnieAerienneVolPk key, String numero, int version) {
		super();
		this.key = key;
		this.numero = numero;
		this.version = version;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public CompagnieAerienneVolPk getKey() {
		return key;
	}

	public void setKey(CompagnieAerienneVolPk key) {
		this.key = key;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		CompagnieAerienneVol other = (CompagnieAerienneVol) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}
	
	
	
	

}
