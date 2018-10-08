package Co_Voiturage.TemchiB3id.Repository;

import org.springframework.data.jpa.repository.JpaRepository;


import Co_Voiturage.TemchiB3id.Model.Offre_User;

public interface UserOffreRepositry extends JpaRepository<Offre_User, Long> {
	

    // les méthodes save(), findOne(), findAll(), count(), delete() sont generées automatiquement par le JPA

}

