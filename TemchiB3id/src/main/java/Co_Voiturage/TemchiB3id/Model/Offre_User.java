package Co_Voiturage.TemchiB3id.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "offre_user")
public class Offre_User {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "id_user")
	private Long id_user;
	
	@Column(name = "id_offre")
	private Long id_offre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Long getId_offre() {
		return id_offre;
	}

	public void setId_offre(Long id_offre) {
		this.id_offre = id_offre;
	}

	public Offre_User(Long id_user, Long id_offre) {
		super();
		this.id_user = id_user;
		this.id_offre = id_offre;
	}
	
	
	

}
