package Co_Voiturage.TemchiB3id.Controller;

import Security.UserSecurity;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Co_Voiturage.TemchiB3id.Model.Profil;
import Co_Voiturage.TemchiB3id.Model.User;
import Co_Voiturage.TemchiB3id.Service.UserServiceImpl;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceImpl x;
	
	
	 // Create a new profil
	 @PostMapping("/user")
	 public ObjectNode createNewUser(@Valid @RequestBody User user) {
		 ObjectNode json = JsonNodeFactory.instance.objectNode();
		 user.setPassword(UserSecurity.hashPassword(user.getPassword()));
		 try {
		 x.AddUser(user);
		 json.put("resultat", "user added");
		 return json;
		 }
		 catch(Exception e) {
			 json.put("resultat", "user not added");
			 return json;
		 }
	 }
	
	 // update user info
	 @PutMapping("/user/{id}")
	 public ObjectNode UpdateUser(@Valid @RequestBody User user, @PathVariable(value = "id") Long Id) {
		 ObjectNode resultat = JsonNodeFactory.instance.objectNode();
		 User o = x.GetUser(Id);
		 try {
			 if(o!=null) {
				 o.setAdresse(user.getAdresse());
				 o.setUsername(user.getUsername());
				 o.setName(user.getName());
				 o.setEmail(user.getEmail());
				 x.UpdateUser(o);
				 resultat.put("resultat", "user modified");
				 return resultat;
			 }
			 else {
				 
				 resultat.put("resultat", "user not found");
				 return resultat;
			 }
		 }
		 catch(Exception e) {
			 resultat.put("resultat", "user not found");
			 return resultat;
		 }
		
	 }
	  // Get a Single user
	  @GetMapping("/user/{id}")
	  
	  public ObjectNode getUserById(@PathVariable(value = "id") Long Id)  {
		  
		  ObjectNode resultat = JsonNodeFactory.instance.objectNode();
		  try {
			  User user = x.GetUser(Id);
			  resultat.put("Name", user.getName());
			  resultat.put("UserName", user.getUsername());
			  resultat.put("Adresse", user.getAdresse());
			  resultat.put("Email", user.getEmail());
			  resultat.put("Profil", user.getProfil().getProfil_name());
			  
			  return resultat;
		  }
		  catch(Exception e) {
			  resultat.put("resultat", "user not found");
			  return resultat;
		  }
		 
	  }
	  
	  // Get all users 
	  @GetMapping("/user/all")
	  
	  public ObjectNode getAllUsers()  {
		  ObjectNode jsonfinal = JsonNodeFactory.instance.objectNode();
		  ArrayNode resultat = JsonNodeFactory.instance.arrayNode();
		  try {
		  List<User> list = x.AllUsers();
		  Iterator<User> itr = list.iterator();
		  while(itr.hasNext()) {
			  User user = itr.next();
			  ObjectNode json = JsonNodeFactory.instance.objectNode();
			  json.put("Name", user.getName());
			  json.put("UserName", user.getUsername());
			  json.put("Adresse", user.getAdresse());
			  json.put("Email", user.getEmail());
			  json.put("Profil", user.getProfil().getProfil_name());
			  
			  resultat.add(json);
		  }
		  jsonfinal.put("Users", resultat);
		  return jsonfinal;
		  }
		  catch(Exception e) {
			  jsonfinal.put("resultat", "No user found");
			  return jsonfinal;
		  }
		  
	  }
	  
	  //delete a user
	  @DeleteMapping("/user/{id}")
	  public ObjectNode deleteUser(@PathVariable(value = "id") Long Id) {
	 	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 	 try {
	 		 x.deleteUser(Id);
	 		json.put("resultat", "User deleted");
	 		return json;
	 	 }
	 	 catch(Exception e) {
	 		 json.put("resultat", "User not found");
	 		 return json;
	 	 }
	 	 
}
	  //Delete all users
	  @DeleteMapping("/user/all")
	  public ObjectNode DeleteAllUser() {
		  ObjectNode json = JsonNodeFactory.instance.objectNode();
		  
		  try {
			  x.deleteAllusers();
		 		 json.put("resultat", "success");
		 		 return json; 
			  
		  }
		  catch(Exception e) {
		 		 json.put("resultat", "No User found");
		 		 return json;
		  }
		  
	  }

}