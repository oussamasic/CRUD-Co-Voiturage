package Co_Voiturage.TemchiB3id.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Co_Voiturage.TemchiB3id.Model.Profil;
import Co_Voiturage.TemchiB3id.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
    public List<User> findByProfil(Profil p);
    public User findByUsername(String username);
    public User findByEmail(String email);
    // les méthodes save(), findOne(), findAll(), count(), delete() sont generées automatiquement par le JPA

}
