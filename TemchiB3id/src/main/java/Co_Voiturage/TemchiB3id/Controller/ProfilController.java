package Co_Voiturage.TemchiB3id.Controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;

import Co_Voiturage.TemchiB3id.Model.Profil;
import Co_Voiturage.TemchiB3id.Repository.ProfilRepository;
import Co_Voiturage.TemchiB3id.Service.ImplProfilService;

@RestController
//l'ensemble des API va commencer par api dans l'URL
@RequestMapping("/api")
public class ProfilController {
	
	@Autowired
	ImplProfilService x;
	@Autowired
	ProfilRepository profilrep;
	
	
	
    // Get All Profils
//  @GetMapping("/profils")
//  public List<Profil> Profils() {
//
//  	 try
//  	 { 
//  		 List<Profil> object =null;
//         object=x.Allprofils();
//         return object;
//         }
//  	 
//  	catch(Exception e)
//  	 {
//  		return null;
//  		}
//  }
  
  // Get a Single profil
  @GetMapping("/profil/{id}")
  
  public ObjectNode getProfilById(@PathVariable(value = "id") Long Id)  {
	  //JSONObject resultat = new JSONObject();
	  ObjectNode resultat = JsonNodeFactory.instance.objectNode();
	  try {
		  
		  Profil p = x.getProfil(Id);
		  resultat.put("id", p.getId());
		  resultat.put("Profil_name", p.getProfil_name());
		  resultat.put("Description", p.getDescription());
		  
		  return resultat;
		  
	  }
	  catch(Exception e) {
		 
		resultat.put("resultat", "Profil Not Found");
	
		  return resultat;
	  }
	 
  }
  
    // Get All Profils
    @SuppressWarnings("deprecation")
	@GetMapping("/profils")
    public ObjectNode Profils() {

    	 try{
    		// ObjectMapper mapper = new ObjectMapper();
    		// ArrayNode list = mapper.createArrayNode();
    		 ArrayNode list = JsonNodeFactory.instance.arrayNode();
    		 ObjectNode jsonfinal = JsonNodeFactory.instance.objectNode();
    		    List<Profil> object =null;
    		    object=x.Allprofils();
    		    
    		    Iterator<Profil> itr = object.iterator();
    		    while(itr.hasNext()) {
    		    Profil element = itr.next();
    		    
    		    // ajout dans un json object
    		    ObjectNode json = JsonNodeFactory.instance.objectNode();
    		    json.put("id", element.getId());
    		    json.put("name", element.getProfil_name());
    		    json.put("description", element.getDescription());
    		       
    		    list.add(json);
    		    
    		    
    		    
    		    
    		      }
    		    jsonfinal.put("Profils", list);
    		    
    		    
    		    return jsonfinal;
    		    
    		  }
    		  catch(Exception e){
    		    
    			  ObjectNode json = JsonNodeFactory.instance.objectNode();
    			 
					json.put("profils", "no profils");
				
    			  return json;
    		  

    }
    
    }
    
    // Delete a profil
 @DeleteMapping("/profil/{id}")
 public ObjectNode deleteProfil(@PathVariable(value = "id") Long Id) {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 try {
		 //p=x.getProfil(Id);
		 x.deleteProfil(Id);
		 json.put("resultat", "Profil deleted");
		 return json;
	 }
	 catch(Exception e) {
		 json.put("resultat", "profil not found");
		 return json;
	 }
	 
	 
 }
 
//Update a profil
 @PutMapping("/profil/{id}")
 public ObjectNode UpdateProfil(@PathVariable(value = "id") Long Id, @Valid @RequestBody Profil user) {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 Profil f;
	 
	 try {
	 f=x.getProfil(Id);
	 if(f!=null) {
		 f.setDescription(user.getDescription());
		 f.setProfil_name(user.getProfil_name());
		 x.updateProfil(f);
		 json.put("resultat", "profil modified");
		 return json;
	 }
	 else {
		 
		 json.put("resultat", "profil not found");
		 return json; 
	 }
	
	 }
	 catch(Exception e) {
		 json.put("resultat", "profil not found");
		 return json; 
		 }
 }
 // Create a new profil
 @PostMapping("/profil")
 public ObjectNode createNewProfil(@Valid @RequestBody Profil user) {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 
	 try {
		 if(user.getDescription().length()==0) {

		 json.put("resultat", "add a description");
		 return json;
		 }
		 else {
		 
		 if(user.getProfil_name().length()==0) {
			 
			 json.put("resultat", "add a name");
			 return json;		 
		 }
		 
		 else {
			 x.addProfil(user);
			 json.put("resultat", "success");
			 return json;
		 }
		 }
	 }
	 catch(Exception e) {
		 json.put("resultat", "Exception found");
		 return json;
	 }
	 
 }
 }
    
