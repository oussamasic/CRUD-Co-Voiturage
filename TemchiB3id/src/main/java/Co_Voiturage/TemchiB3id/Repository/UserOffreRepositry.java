package Co_Voiturage.TemchiB3id.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import Co_Voiturage.TemchiB3id.Model.Offre_User;

public interface UserOffreRepositry extends JpaRepository<Offre_User, Long> {
	
	public List<Offre_User> findByIdoffre(Long idoffre );
	public List<Offre_User> findByIduser(Long iduser);
	//public List<Offre_User> findByUser(Long id_user );
	
    // les méthodes save(), findOne(), findAll(), count(), delete() sont generées automatiquement par le JPA

}

