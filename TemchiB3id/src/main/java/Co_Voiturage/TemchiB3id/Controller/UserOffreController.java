package Co_Voiturage.TemchiB3id.Controller;

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

import Co_Voiturage.TemchiB3id.Model.Offre_User;
import Co_Voiturage.TemchiB3id.Service.ImplUserOffreService;

@RestController
//l'ensemble des API va commencer par api dans l'URL
// 7 méthodes
@RequestMapping("/api")
public class UserOffreController {

	@Autowired
	ImplUserOffreService xx;
	
	
    // Delete a useroffre
 @DeleteMapping("/offreuser/{id}")
 public ObjectNode deleteOffreUser(@PathVariable(value = "id") Long Id) {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 try {
		 Offre_User y = xx.getOffreUser(Id);
		 xx.deleteUserOffre(y);
		 json.put("resultat", "offreuser deleted");
		 return json;
		 
	 }
	 catch(Exception e) {
		 json.put("resultat", "offreuser not found");
		 return json;
		 
	 }
 
	 
 }
 
 //delete all OffreUser
 @DeleteMapping("/offreuser/deleteAll")
 public ObjectNode DeleteAllOffreUser() {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 try {
		 xx.deleteAll();
		 json.put("resultat", "offreusers are deleted");
		 return json;
	 }
	 catch(Exception e) {
		 json.put("resultat", "offreuser not found");
		 return json;
	 }
	
 }
 //Create new OffreUser
 
 @PostMapping("/offreuser")
 public ObjectNode NewOffreUser(@Valid @RequestBody Offre_User o) {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 try {
		 xx.NewUserOffre(o);
		 json.put("resultat", "success");
		 return json;
	 }
	 catch(Exception e)
	 {
		 json.put("resultat", "failed");
		 return json; 
	 }
	
}
 // get all OffreUser
 @GetMapping("/offreuser/all")
 public ArrayNode GetAllOffreUser() {
	 ArrayNode list = JsonNodeFactory.instance.arrayNode();
	 try {
		 
		 List<Offre_User> object ;
		 object=xx.AllOffers();
		 
		    Iterator<Offre_User> itr = object.iterator();
		    while(itr.hasNext()) {
		    Offre_User element = itr.next();
		    
		    // ajout des object dans le fichier json
		    
		    ObjectNode json = JsonNodeFactory.instance.objectNode();
		    json.put("id", element.getId());
		    json.put("offre_id", element.getIdoffre());
		    json.put("user_id", element.getIduser());
		       
		    list.add(json);
		    }
		    return list;
	 }
	 catch(Exception e) {
		    ObjectNode json = JsonNodeFactory.instance.objectNode();
            json.put("profils", "no profils");
			list.add(json);
			return list;
	 }
	
 }
 //Get an OffreUser
 @GetMapping("/offreuser/{id}")
 public ObjectNode GetOffreUser(@PathVariable(value = "id") Long Id) {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 Offre_User f ;
	 try {
		 f=xx.getOffreUser(Id);
		 json.put("Offre_id", f.getIdoffre());
		 json.put("User_id", f.getIduser());
             return json;
	 }
	 catch(Exception e) {
		 json.put("resultat", "offreuser not found");
		 return json;
	 }

 }
 //Update an OffreUser
 @PutMapping("/offreuser/{id}")
 public ObjectNode UpdateOffreUser(@PathVariable(value = "id") Long Id, @Valid @RequestBody Offre_User o) {
	 ObjectNode json = JsonNodeFactory.instance.objectNode();
	 Offre_User t;
	 try {
		 t=xx.getOffreUser(Id);
		 if(t!=null) {
		 t.setIdoffre(o.getIdoffre());
		 t.setIduser(o.getIduser());
		 xx.updateoffreuser(t);
		 
		 json.put("resultat", "offreuser bien modifié");
		 return json;
		 }
		 else {
			 
			 json.put("resultat", "offreuser not found");
			 return json; 
		 }
	 }
	 catch(Exception e) {
		 json.put("resultat", "offreuser not found");
		 return json;
		 
	 }
	 
	
 }
	
}
