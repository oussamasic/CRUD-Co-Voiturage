package Co_Voiturage.TemchiB3id.Service;

import java.util.List;

import Co_Voiturage.TemchiB3id.Model.Offre;
import Co_Voiturage.TemchiB3id.Model.Offre_User;
import Co_Voiturage.TemchiB3id.Model.User;

public interface UserOffreService {
	
	public List<Offre_User> AllOffers();
	public Offre_User getOffreUser(Long id);
	public List<Offre_User> ListOfOffre(Long id);
	public List<Offre_User> Chauffeur(Long id);
	public void NewUserOffre(Offre_User f);
	public void deleteUserOffre(Offre_User f);
	public void deleteAll();
	

}
