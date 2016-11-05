package br.com.contesti.controller;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contesti.entidades.Usuario;
import br.com.contesti.repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastro")
public class UsuarioController {

	@Autowired
    private UsuarioRepository usuarioRepository;

	@RequestMapping(value = "/criarUsuario", method=RequestMethod.POST)
    @ResponseBody  
    public String create(@RequestParam String nome_usuario,@RequestParam String login,
    					 @RequestParam String senha,@RequestParam String email,
    					 Boolean ativo,
    					 @RequestParam String confirmar_senha,
    					 Model model,
    					 @Valid Usuario usuario, BindingResult result) throws NoSuchAlgorithmException, UnsupportedEncodingException{	
		
    		if(senha.equals(confirmar_senha)){    	
    			ativo = true;
    			MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
    			byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));
    			StringBuilder hexString = new StringBuilder();
    			for(byte b: messageDigest){
    				hexString.append(String.format("%02X",  0xFF & b));
    			}
    			senha = hexString.toString();
    			usuarioRepository.save(usuario);    	       	
    	    	return "Sucesso!!!";
    		}else{
    			return "Senha diferente";
    		}
    }
	

}
	
//	@RequestMapping(value = "/testeUsuario")
//    @ResponseBody
//   
//    public String create(String nome_usuario, String login, String senha, String email, Boolean permissao){	
//		System.out.println("ANTES DO TRY");
//    	try{    	
//    		System.out.println("NO TRY");
//    		usuarioRepository.save(new Usuario("bruno", "caveiraman", "eueu" , "Teste@caveiraman@hotmail.com", false));
//       	}catch(Exception ex){
//    		System.out.println("EXCEÇÃO");
//    		return "Error" + ex.toString();
//    	} 
//    	return "Sucesso!!!";
//	
//	}
//}
