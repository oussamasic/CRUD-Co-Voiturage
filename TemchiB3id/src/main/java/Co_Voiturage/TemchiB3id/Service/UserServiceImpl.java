package Co_Voiturage.TemchiB3id.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Co_Voiturage.TemchiB3id.Model.Profil;
import Co_Voiturage.TemchiB3id.Model.User;
import Co_Voiturage.TemchiB3id.Repository.ProfilRepository;
import Co_Voiturage.TemchiB3id.Repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	private final UserRepository userrepo;
	private final ProfilRepository profilrepo;
	
	@Autowired
	public UserServiceImpl(UserRepository f,ProfilRepository y) {
		
		this.userrepo=f;
		this.profilrepo=y;
	}
	@Override
	public List<User> AllUsers() {
		List<User> list;
		list=userrepo.findAll();
		return list;
	}

	@Override
	public List<User> AllDriver() {
		// TODO Auto-generated method stub
		Profil p;
		p= profilrepo.findOne((long) 1);
		List<User> list;
		list=userrepo.findByProfil(p);
		return list;
	}

	@Override
	public List<User> AllRequestors() {
		Profil p;
		p= profilrepo.findOne((long) 2);
		List<User> list;
		list=userrepo.findByProfil(p);
		return list;
	}

	@Override
	public User GetUser(Long id) {
		User u;
		u=userrepo.getOne(id);
		return u;
	}

	@Override
	public void deleteUser(Long id) {
	userrepo.delete(id);
		
	}

	@Override
	public void UpdateUser(User user) {
		userrepo.save(user);
		
	}

	@Override
	public void AddUser(User user) {
		userrepo.save(user);
		
	}

	@Override
	public User UserConnexion(String x, String y) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
