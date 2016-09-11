  package br.com.contesti;
   
  import org.springframework.beans.factory.annotation.Autowired;
  import org.springframework.stereotype.Controller;
  import org.springframework.ui.Model;
  import org.springframework.web.bind.annotation.PathVariable;
  import org.springframework.web.bind.annotation.RequestMapping;
  import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contesti.entidades.Usuario;
   
  import java.util.List;
   
  @Controller
  @RequestMapping("/")
  public class UsuarioController {
	  
	  @RequestMapping("/create")
	  @ResponseBody
	  public String create(String nome_usuario, String login, String senha, String email) {
	    String userId = "";
	    try {
	      Usuario usuario = new Usuario(nome_usuario, login,senha,email);
	      usuarioDao.save(usuario);
	      nome_usuario = String.valueOf(usuario.getIdUsuario());
	    }
	    catch (Exception ex) {
	      return "Error creating the user: " + ex.toString();
	    }
	    return "User succesfully created with id = " + userId;
	  }
	  
	  /**
	   * GET /delete  --> Delete the user having the passed id.
	   */
	  @RequestMapping("/delete")
	  @ResponseBody
	  public String delete(int idUsuario) {
	    try {
	      Usuario usuario = new Usuario();
	      usuarioDao.delete(usuario);
	    }
	    catch (Exception ex) {
	      return "Error deleting the user:" + ex.toString();
	    }
	    return "User succesfully deleted!";
	  }
	  
	  /**
	   * GET /get-by-email  --> Return the id for the user having the passed
	   * email.
	   */
	  @RequestMapping("/get-by-email")
	  @ResponseBody
	  public String getByEmail(String email) {
	    String userId = "";
	    try {
	      Usuario usuario = usuarioDao.findByEmail(email);
	      usuario = String.valueOf(usuario.getIdUsuario());
	    }
	    catch (Exception ex) {
	      return "User not found";
	    }
	    return "The user id is: " + userId;
	  }
	  
	  /**
	   * GET /update  --> Update the email and the name for the user in the 
	   * database having the passed id.
	   */
	  @RequestMapping("/update")
	  @ResponseBody
	  public String updateUser(String nome_usuario, String login, String senha, String email) {
	    try {
	      Usuario usuario = usuarioDao.findOne(nome_usuario);
	      usuario.setEmail(email);
	      usuario.setNome_usuario(nome_usuario);
	      usuarioDao.save(usuario);
	    }
	    catch (Exception ex) {
	      return "Error updating the user: " + ex.toString();
	    }
	    return "User succesfully updated!";
	  }

	  // Private fields

	  @Autowired
	  private Usuario usuarioDao;
	  
	
  }