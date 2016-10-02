package br.com.contesti.controller;

import java.io.Console;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	
	@RequestMapping("/")
	public String index(){
		System.out.println("Hello World!");
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(){
		System.out.println("Hello LOGIN!");
		return "Login";
	}
	
	@RequestMapping("/cadastroQuestao")
	public String cadastro(){
		System.out.println("Hello uestao");
		return "CadastroQuestao";
	}
	
	
	
}
