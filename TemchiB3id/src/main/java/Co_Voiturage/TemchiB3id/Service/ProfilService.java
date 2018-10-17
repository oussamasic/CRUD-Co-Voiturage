package Co_Voiturage.TemchiB3id.Service;

import java.util.List;

import Co_Voiturage.TemchiB3id.Model.Profil;

public interface ProfilService {

	public List<Profil> Allprofils();
	public Profil getProfil(Long id);
	public void addProfil(Profil profil);
	public void deleteProfil(Long f);
	public void updateProfil(Profil f);
	public void deleteAllProfils();
	
}
