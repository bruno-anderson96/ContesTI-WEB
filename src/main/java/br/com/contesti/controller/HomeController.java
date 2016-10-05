package br.com.contesti.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String login(){
		System.out.println("Hello LOGIN!");
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
