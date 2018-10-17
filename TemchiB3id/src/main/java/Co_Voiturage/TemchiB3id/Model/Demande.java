package Co_Voiturage.TemchiB3id.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;


@Entity
@Table(name = "demande")
public class Demande {
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
    @Column(name = "depart")
    @Size(min = 2, max =50)
    @Pattern(regexp = "[A-Za-z. ]*", message = "depart requires valid character")
	private String depart;
    
    @Column(name = "arrivee")
    @Size(min = 2, max =50)
    @Pattern(regexp = "[A-Za-z. ]*", message = "arrivee requires valid character")
	private String arrivee;
    
    @Column( updatable = true, name = "heure_depart")
    @Temporal(TemporalType.TIMESTAMP)
	private Date heure;
	
    @Column( updatable = true, name = "Date_depart")
    @Temporal(TemporalType.TIMESTAMP)
	private Date date_depart;
	
    @Column( updatable = false, name = "Date_creation")
    @Temporal(TemporalType.TIMESTAMP)
	private Date date_creation;
	
    @Column( updatable = true, name = "Date_Modification")
    @Temporal(TemporalType.TIMESTAMP)
    
	private Date date_modification;
    
    @Column(name = "nombre_places")
	private int nbr_place;
    
    @Column(name = "nombre_place_diponible")
	private int nbr_place_dispo;
	
	@Column(name = "id_demandeur")
	private Long id_user;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDepart() {
		return depart;
	}

	public void setDepart(String depart) {
		this.depart = depart;
	}

	public String getArrivee() {
		return arrivee;
	}

	public void setArrivee(String arrivee) {
		this.arrivee = arrivee;
	}

	public Date getHeure() {
		return heure;
	}

	public void setHeure(Date heure) {
		this.heure = heure;
	}

	public Date getDate_depart() {
		return date_depart;
	}

	public void setDate_depart(Date date_depart) {
		this.date_depart = date_depart;
	}

	public Date getDate_creation() {
		return date_creation;
	}

	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_modification() {
		return date_modification;
	}

	public void setDate_modification(Date date_modification) {
		this.date_modification = date_modification;
	}

	public int getNbr_place() {
		return nbr_place;
	}

	public void setNbr_place(int nbr_place) {
		this.nbr_place = nbr_place;
	}

	public int getNbr_place_dispo() {
		return nbr_place_dispo;
	}

	public void setNbr_place_dispo(int nbr_place_dispo) {
		this.nbr_place_dispo = nbr_place_dispo;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Demande(String depart, String arrivee, Date heure, Date date_depart, Date date_creation,
			Date date_modification, int nbr_place, int nbr_place_dispo, Long id_user) {
		super();
		this.depart = depart;
		this.arrivee = arrivee;
		this.heure = heure;
		this.date_depart = date_depart;
		this.date_creation = date_creation;
		this.date_modification = date_modification;
		this.nbr_place = nbr_place;
		this.nbr_place_dispo = nbr_place_dispo;
		this.id_user = id_user;
	}
	
	
	

}
