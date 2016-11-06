package br.com.contesti.controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.contesti.entidades.Usuario;
import br.com.contesti.repository.UsuarioRepository;

@Controller
@RequestMapping("/cadastro")
public class UsuarioController {

	@Autowired
    private UsuarioRepository usuarioRepository;
	
	

	@RequestMapping(value = "/criarUsuario", method=RequestMethod.POST)
    @ResponseBody  
    public ModelAndView create(@RequestParam String nome_usuario,@RequestParam String login,
    					 @RequestParam String senha,@RequestParam String email,
    					 @RequestParam String confirmar_senha,
    					 Boolean ativo,
    					 Model model, RedirectAttributes attributes,
    					 @Valid Usuario usuario, BindingResult result) throws NoSuchAlgorithmException, UnsupportedEncodingException{	
		
			List<Usuario> u = usuarioRepository.findByLogin(login);
			
			if(u.size() != 0){
				
				ModelAndView mv = new ModelAndView("redirect:/cadastro");
    			attributes.addFlashAttribute("mensagem", "Usuário já existe");
    			    			    			   	       	
    	    	return mv;
				    	    	
			}else{
				if(senha.equals(confirmar_senha)){ 
					if(usuario.isEmailValid(email)){
					senha = usuario.criptografar(senha);
        		
        			
        			usuarioRepository.save(new Usuario(nome_usuario,login,senha,email)); 
        			ModelAndView mv = new ModelAndView("redirect:/cadastro");
        			attributes.addFlashAttribute("mensagem", "Usuário criado com sucesso!");
        			    			   	       	
        	    	return mv;
					}else{
						ModelAndView mv = new ModelAndView("redirect:/cadastro");
	        			attributes.addFlashAttribute("mensagem", "Email inválido");
	        			return mv;
					}
        		}else{
        			ModelAndView mv = new ModelAndView("redirect:/cadastro");
        			attributes.addFlashAttribute("mensagem", "Erro");
        			return mv;
        		}
    		
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
