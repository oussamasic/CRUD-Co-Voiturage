package Co_Voiturage.TemchiB3id.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Co_Voiturage.TemchiB3id.Model.Profil;


@Repository
public interface ProfilRepository extends JpaRepository<Profil, Long> {
	

    // les méthodes save(), findOne(), findAll(), count(), delete() sont generées automatiquement par le JPA

}
