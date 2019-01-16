package tpVol.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="escale")
public class Escale {

	@EmbeddedId // Pour relier à l'Id d'une autre table (=> faut mettre @Embeddable dans l'autre table)
	private EscalePk key;
	@Column(name="free_coffee")
	private boolean cafeOffert;

	public Escale() {
	}

	public Escale(EscalePk key, boolean cafeOffert) {
		super();
		this.key = key;
		this.cafeOffert = cafeOffert;
	}

	public EscalePk getKey() {
		return key;
	}

	public void setKey(EscalePk key) {
		this.key = key;
	}

	public boolean isCafeOffert() {
		return cafeOffert;
	}

	public void setCafeOffert(boolean cafeOffert) {
		this.cafeOffert = cafeOffert;
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
		Escale other = (Escale) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
