package Co_Voiturage.TemchiB3id.Service;

import java.util.List;

import Co_Voiturage.TemchiB3id.Model.User;

public interface UserService {
	
	public List<User> AllUsers();
	public List<User> AllDriver();
	public List<User> AllRequestors();
	public User GetUser(Long id);
	public void deleteUser(Long id);
	public void deleteAllusers();
	public void UpdateUser(User user);
	public void AddUser(User user);
	public User UserConnexion(String x, String y);
	

}
