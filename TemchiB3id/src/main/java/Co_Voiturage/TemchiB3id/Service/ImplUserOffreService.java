package Co_Voiturage.TemchiB3id.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import Co_Voiturage.TemchiB3id.Model.Offre;
import Co_Voiturage.TemchiB3id.Model.Offre_User;
import Co_Voiturage.TemchiB3id.Model.User;
import Co_Voiturage.TemchiB3id.Repository.UserOffreRepositry;

public class ImplUserOffreService implements UserOffreService {

	
	
	private final UserOffreRepositry useroffre;
	
	@Autowired
	public ImplUserOffreService(UserOffreRepositry f) {
		
		this.useroffre=f;
	}
	
	@Override
	public List<Offre_User> AllOffers() {
		// TODO Auto-generated method stub
		List<Offre_User> list = useroffre.findAll();
		return list;
	}

	@Override
	public Offre_User getOffreUser(Long id) {
		// TODO Auto-generated method stub
		Offre_User offre = useroffre.getOne(id);
		
		return offre;
	}

	@Override
	public List<Offre_User> ListOfOffre(Long id) {
		List<Offre_User> list = useroffre.findByUser(id);
		return list;
	}

	@Override
	public List<Offre_User> Chauffeur(Long id) {
		// TODO Auto-generated method stub
		List<Offre_User> list = useroffre.findByOffre(id);
		return list;
	}

	@Override
	public void NewUserOffre(Offre_User f) {
		// TODO Auto-generated method stub
		useroffre.save(f);
		
	}

	@Override
	public void deleteUserOffre(Offre_User f) {
		// TODO Auto-generated method stub
		useroffre.delete(f);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		useroffre.deleteAll();
		
	}

}
