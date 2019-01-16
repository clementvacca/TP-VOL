package tpVol.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "login")
@SequenceGenerator(name = "seqLogin", sequenceName = "seq_login", allocationSize = 1, initialValue = 100)
public class Login {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogin")
	@Column(name = "no_login", length = 150, nullable = false)
	private Long id;
	@Column(name = "login", length = 150, nullable = false)
	private String login;
	@Column(name = "password", length = 150, nullable = false)
	private String motDePasse;
	@Column(name = "admin", length = 150, nullable = false)
	private Boolean admin;
	@OneToOne(mappedBy="login")
	private Client client;
	
	
	public Login() {
		super();
	}

	public Login(String login, String motDePasse, Boolean admin) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Login other = (Login) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
