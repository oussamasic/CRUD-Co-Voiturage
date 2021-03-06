package Co_Voiturage.TemchiB3id.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import java.io.Serializable;
import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user")


// classe pour les users de l'application : conducteur et demandeur
public class User implements Serializable {

	// user(id, nom complet, username, email, adresse,  date naissance, type de profil)
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
	
	    @Column(name = "nom_complet")
	    @Size(min = 2)
	    @Pattern(regexp = "[A-Za-z. ]*", message = "your complete name requires valid character")
	    private String Name;
	    
	    @Column(name = "password")
	    //@Size(min = 60)
	    private String password;
	  

		@Column(name = "username")
	    @Size(min = 2)
	    @Pattern(regexp = "[A-Za-z. ]*", message = "your  username requires valid character")
	    private String username;
	
	    @NotNull(message =  "Email requires valid value")
	    @NotEmpty(message = "Email requires non empty value")
	    @Email(message =    "Email requires valid format")
	    @Column(name = "email")
	    private String email;

	    @Column(name = "adresse")
	    private String adresse;
	    
	    
	    @Column( updatable = false, name = "Date_Naissance")
        @Temporal(TemporalType.TIMESTAMP)
	    private Date naissance;

	
    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="profil_id", nullable=true)
    private Profil profil;
    
    
 


	public User() {
		super();
	}
	
  
	
	public User(Long id, String username, String password, String name, String email, String adresse, Date naissance, Profil profil) {
		super();
		this.id = id;
		this.password=password;
		this.username = username;
		this.Name = name;
		this.email = email;
		this.adresse = adresse;
		this.naissance = naissance;
		this.profil = profil;
	}
	
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", Name=" + Name + ", Email=" + email + ", adresse="
				+ adresse + ", naissance=" + naissance + ", profil=" + profil + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	
	  public String getPassword() {
			return password;
		}


		public void setPassword(String password) {
			this.password = password;
		}


	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public Date getNaissance() {
		return naissance;
	}
	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}
	public Profil getProfil() {
		return profil;
	}
	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	
	
	
	

}
