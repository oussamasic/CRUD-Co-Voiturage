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
	private Long iduser;
	
	@Column(name = "id_offre")
	private Long idoffre;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public Long getIduser() {
		return iduser;
	}

	public void setIduser(Long iduser) {
		this.iduser = iduser;
	}

	public Long getIdoffre() {
		return idoffre;
	}

	public void setIdoffre(Long idoffre) {
		this.idoffre = idoffre;
	}

	public Offre_User(Long id, Long iduser, Long idoffre) {
		super();
		this.id = id;
		this.iduser = iduser;
		this.idoffre = idoffre;
	}

	public Offre_User(Long iduser, Long idoffre) {
		super();
		this.iduser = iduser;
		this.idoffre = idoffre;
	}

	public Offre_User() {
		super();
	}


	
	
	

}
