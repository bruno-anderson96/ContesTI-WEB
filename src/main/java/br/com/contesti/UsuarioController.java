<<<<<<< HEAD
//package br.com.contesti;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import br.com.contesti.entidades.Usuario;
//import br.com.contesti.repository.UsuarioRepository;
//
//@RestController
//@RequestMapping("/user")
//public class UsuarioController {
//
//	@Autowired
//	private UsuarioRepository usuRepo;
//
//	@RequestMapping(method = RequestMethod.GET)
//	public String novo() {
//		return "usuario/cadastro";
//	}
//
//	@RequestMapping("/save")
//	@ResponseBody
//	public String salvar(String nome_usuario, String login, String senha, String email) {
//		String userId = "";
//		try {
//			Usuario usuario = new Usuario(nome_usuario, login, senha, email);
//
//			usuRepo.save(usuario);
//			nome_usuario = String.valueOf(usuario.getIdUsuario());
//		} catch (Exception ex) {
//			return "Error creating the user: " + ex.toString();
//		}
//		return "User succesfully created with id = " + userId;
//	}
//
//	/**
//	 * GET /delete --> Delete the user having the passed id.
//	 */
//	@RequestMapping("/delete")
//	@ResponseBody
//	public String deletar(int idUsuario) {
//		try {
//			Usuario usuario = new Usuario();
//			usuRepo.delete(usuario.getIdUsuario());
//		} catch (Exception ex) {
//			return "Error deleting the user:" + ex.toString();
//		}
//		return "User succesfully deleted!";
//	}
//
//	/**
//	 * GET /get-by-email --> Return the id for the user having the passed email.
//	 */
//
//	/**
//	 * GET /update --> Update the email and the name for the user in the
//	 * database having the passed id.
//	 */
//	/*
//	 * @RequestMapping("/update")
//	 * 
//	 * @ResponseBody public String updateUser(String nome_usuario, String login,
//	 * String senha, String email) { try { Usuario usuario =
//	 * usuRepo.findOne(nome_usuario); usuario.setEmail(email);
//	 * usuario.setNome_usuario(nome_usuario); usuRepo.save(usuario); } catch
//	 * (Exception ex) { return "Error updating the user: " + ex.toString(); }
//	 * return "User succesfully updated!"; }
//	 */
//
//}
=======
package br.com.contesti;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contesti.entidades.Usuario;
import br.com.contesti.repository.UsuarioRepository;

@Controller
@RequestMapping("/user")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuRepo;

	@RequestMapping(method = RequestMethod.GET)
	public String novo() {
		return "usuario/cadastro";
	}

	@RequestMapping("/save")
	@ResponseBody
	public String salvar(String nome_usuario, String login, String senha, String email) {
		String userId = "";
		try {
			Usuario usuario = new Usuario(nome_usuario, login, senha, email);

			usuRepo.save(usuario);
			nome_usuario = String.valueOf(usuario.getIdUsuario());
		} catch (Exception ex) {
			return "Error creating the user: " + ex.toString();
		}
		return "User succesfully created with id = " + userId;
	}

	/**
	 * GET /delete --> Delete the user having the passed id.
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public String deletar(int idUsuario) {
		try {
			Usuario usuario = new Usuario();
			usuRepo.delete(usuario.getIdUsuario());
		} catch (Exception ex) {
			return "Error deleting the user:" + ex.toString();
		}
		return "User succesfully deleted!";
	}

	/**
	 * GET /get-by-email --> Return the id for the user having the passed email.
	 */

	/**
	 * GET /update --> Update the email and the name for the user in the
	 * database having the passed id.
	 */
	/*
	 * @RequestMapping("/update")
	 * 
	 * @ResponseBody public String updateUser(String nome_usuario, String login,
	 * String senha, String email) { try { Usuario usuario =
	 * usuRepo.findOne(nome_usuario); usuario.setEmail(email);
	 * usuario.setNome_usuario(nome_usuario); usuRepo.save(usuario); } catch
	 * (Exception ex) { return "Error updating the user: " + ex.toString(); }
	 * return "User succesfully updated!"; }
	 */

}
>>>>>>> 38e5639c3837db03f40ac6c137d2896b02fb1943
