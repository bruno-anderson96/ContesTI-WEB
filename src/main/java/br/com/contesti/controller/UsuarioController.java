package br.com.contesti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import br.com.contesti.entidades.Usuario;
import br.com.contesti.repository.UsuarioRepository;

@Controller
@RequestMapping
public class UsuarioController {

	@Autowired
    private UsuarioRepository usuarioRepository;
    
	@RequestMapping(value = "/testeUsuario")
    @ResponseBody
   
    public String create(String nome_usuario, String login, String senha, String email
    		 ){	
		System.out.println("ANTES DO TRY");
    	try{    	
    		System.out.println("NO TRY");
    		usuarioRepository.save(new Usuario("bruno", "caveiraman", "eueu" , "Teste@caveiraman@hotmail.com"));
       	}catch(Exception ex){
    		System.out.println("EXCEÇÃO");
    		return "Error" + ex.toString();
    	} 
    	return "Sucesso!!!";
	
	}
}
