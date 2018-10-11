package Co_Voiturage.TemchiB3id.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import Co_Voiturage.TemchiB3id.Model.Offre_User;

public interface UserOffreRepositry extends JpaRepository<Offre_User, Long> {
	
	List<Offre_User> findByOffre(Long id_offre );
	List<Offre_User> findByUser(Long id_user );
	
    // les méthodes save(), findOne(), findAll(), count(), delete() sont generées automatiquement par le JPA

}

