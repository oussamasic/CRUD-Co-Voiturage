package Co_Voiturage.TemchiB3id.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Co_Voiturage.TemchiB3id.Model.Profil;
import Co_Voiturage.TemchiB3id.Repository.ProfilRepository;

@Service
public class ImplProfilService implements ProfilService {

	private final ProfilRepository profilrep;
	
	
	@Autowired
	public ImplProfilService(ProfilRepository f) {
		this.profilrep=f;
	}
	@Override
	public List<Profil> Allprofils() {
		// TODO Auto-generated method stub
		List<Profil> x;
		x = profilrep.findAll();
        return x;
	}

	@Override
	public Profil getProfil(Long id) {
		Profil x = profilrep.findOne( id);
		return x;
	}

	@Override
	public void addProfil(Profil profil) {
		
		profilrep.save(profil);
		
	}

	@Override
	public void deleteProfil(Long f) {
		profilrep.delete(f);
		
	}

	@Override
	public void updateProfil(Profil f) {
		profilrep.save(f);
		
	}

	@Override
	public void deleteAllProfils() {
		profilrep.deleteAll();
		
	}
	
	
	

}
