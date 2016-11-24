package br.com.contesti.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.contesti.entidades.Role;
import br.com.contesti.entidades.Usuario;
import br.com.contesti.repository.AssuntoRepository;
import br.com.contesti.repository.BancaRepository;
import br.com.contesti.repository.DisciplinaRepository;
import br.com.contesti.repository.RoleRepository;
import br.com.contesti.repository.UsuarioRepository;

@Controller
public class HomeController {

	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private BancaRepository bancaRepository;
	
	
	
	
	@Autowired
	private RoleRepository roleRepository;
	
	@RequestMapping("/testeT")
	public String testeT(){
		return "testeThyme";
	}
		
	@RequestMapping("/")
	public String login(){		
		return "Login";	
	}
	
	@RequestMapping("/home")
	public String index(){			
		return "PaginaInicialUser";	
	}
	
	@RequestMapping("/homeAdm")
	public ModelAndView indexAdmin(){	
		ModelAndView mav = new ModelAndView("PaginaInicialAdm");
		mav.addObject("listarUsuario", usuarioRepository.findAll());
		mav.addObject("listarRole", roleRepository.findAll());
		mav.addObject("listarDisciplina", disciplinaRepository.findAll());
		return mav;	
	}
	
	@RequestMapping("/cadastroQuestaoUsuario")
	public ModelAndView cadastroQuestao(){
		ModelAndView mav = new ModelAndView("CadastroQuestaoUser");
		mav.addObject("listarDisciplina", disciplinaRepository.findAll());
		mav.addObject("listarAssunto", assuntoRepository.findAll());	
		return mav;
	}
	
	@RequestMapping("/cadastroQuestaoConcurso")
	public ModelAndView cadastroQuestaoConcurso(){
		ModelAndView mav = new ModelAndView("CadastroQuestaoBC");
		mav.addObject("listarDisciplina", disciplinaRepository.findAll());
		mav.addObject("listarAssunto", assuntoRepository.findAll());
		mav.addObject("listarBanca", bancaRepository.findAll());
		return mav;
	}	
		
	@RequestMapping("/cadastro")
	public String cadastro(){		
		return "cadastro";
	}
	
	@RequestMapping("/Sobre")
	public String sobre(){	
		return "Sobre";
	}
	
	
	
}
