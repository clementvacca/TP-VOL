package tpVol.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "airport")
@SequenceGenerator(name = "seqAeroport", sequenceName = "seq_airport", allocationSize = 1, initialValue = 1)
public class Aeroport {
		@Id
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
		@Column(name = "id_airport", length = 150, nullable = true)
		private Long idAeroport;
		@Column(name = "name_airport", length = 150, nullable = false)
		private String nomAeroport;
		@ManyToOne
		@JoinColumn(name = "id_city")
		private Ville ville;
		@OneToMany(mappedBy="aeroportDepart")
		private List<Vol> volsDepart;
		@OneToMany(mappedBy="aeroportArrivee")
		private List<Vol> volsArrivee;
		@OneToMany(mappedBy="key.aeroport")
		private List<Escale> escales;
		
		
		public Aeroport () {
			
		}
		public Aeroport(String nomAeroport, Ville ville) {
			super();
			this.nomAeroport = nomAeroport;
			this.ville = ville;
		}
		public Long getIdAeroport() {
			return idAeroport;
		}
		
		public String getNomAeroport() {
			return nomAeroport;
		}
		public void setNomAeroport(String nomAeroport) {
			this.nomAeroport = nomAeroport;
		}
		public Ville getVille() {
			return ville;
		}
		public void setVille(Ville ville) {
			this.ville = ville;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((idAeroport == null) ? 0 : idAeroport.hashCode());
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
			Aeroport other = (Aeroport) obj;
			if (idAeroport == null) {
				if (other.idAeroport != null)
					return false;
			} else if (!idAeroport.equals(other.idAeroport))
				return false;
			return true;
		}
		
		
		
		
		
}
