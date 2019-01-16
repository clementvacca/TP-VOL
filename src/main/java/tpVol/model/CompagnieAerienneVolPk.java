package tpVol.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class CompagnieAerienneVolPk implements Serializable{
	
	@ManyToOne
	@JoinColumn(name = "compagnie_aerienne_pk")
	private CompagnieAerienne compagnieAerienneVol;
	@ManyToOne
	@JoinColumn(name = "vol_pk")
	private Vol vol;
	
	public CompagnieAerienneVolPk() {
		// TODO Auto-generated constructor stub
	}

	public CompagnieAerienneVolPk(CompagnieAerienne compagnieAerienneVol, Vol vol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
		this.vol = vol;
	}

	public CompagnieAerienne getCompagnieAerienneVol() {
		return compagnieAerienneVol;
	}

	public void setCompagnieAerienneVol(CompagnieAerienne compagnieAerienneVol) {
		this.compagnieAerienneVol = compagnieAerienneVol;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((compagnieAerienneVol == null) ? 0 : compagnieAerienneVol.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		CompagnieAerienneVolPk other = (CompagnieAerienneVolPk) obj;
		if (compagnieAerienneVol == null) {
			if (other.compagnieAerienneVol != null)
				return false;
		} else if (!compagnieAerienneVol.equals(other.compagnieAerienneVol))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}
	
	

}
