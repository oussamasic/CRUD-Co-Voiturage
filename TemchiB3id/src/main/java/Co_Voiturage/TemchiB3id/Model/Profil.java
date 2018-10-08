package Co_Voiturage.TemchiB3id.Model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "profil")
public class Profil {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "profil_name")
	private String profil_name;
	
	@Column(name = "description")
	private String description;
	
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,mappedBy = "profil")
	private Set<User> partants = new HashSet<>();
	
	
	
	
	public Set<User> getPartants() {
		return partants;
	}
	public void setPartants(Set<User> partants) {
		this.partants = partants;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProfil_name() {
		return profil_name;
	}
	public void setProfil_name(String profil_name) {
		this.profil_name = profil_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "Profil [id=" + id + ", profil_name=" + profil_name + ", description=" + description + "]";
	}
	public Profil(Long id, String profil_name, String description) {
		super();
		this.id = id;
		this.profil_name = profil_name;
		this.description = description;
	}
	public Profil() {
		super();
	}

	
	
}
