package br.com.contesti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import br.com.contesti.repository.UsuarioRepository;
import br.com.contesti.entidades.Usuario;

@Controller
public class HomeController {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@RequestMapping("/testeT")
	public String testeT(){
		System.out.println("Hello Thymeleaf!!");
		return "testeThyme";
	}
	
	
	@RequestMapping("/")
	public String login(){	
		System.out.println("Hello Login!!");		
		return "Login";
	
	}
		
	@RequestMapping("/cadastroQuestao")
	public String cadastroQuestao(){
		System.out.println("Hello questao");
		return "CadastroQuestao";
	}
	
	@RequestMapping("/cadastro")
	public String cadastro(){
		System.out.println("Hello usuario");
		return "cadastro";
	}
	
	@RequestMapping("/sobre")
	public String sobre(){
		System.out.println("Hello usuario");
		return "Sobre";
	}
	
	
	
}
