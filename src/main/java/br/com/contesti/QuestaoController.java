package br.com.contesti;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class QuestaoController {
	
	
	@RequestMapping("/CadastroQuestao")	
	public ModelAndView recebeParam(Model model){
		String nome = "Bem Vindo ao ContesTI!!!";
		model.addAttribute(nome);
	return new ModelAndView("CadastroQuestao.html", "nome", nome);
	}

		
	}
