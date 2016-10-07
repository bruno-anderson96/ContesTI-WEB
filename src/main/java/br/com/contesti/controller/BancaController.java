package br.com.contesti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import br.com.contesti.entidades.Banca;
import br.com.contesti.repository.BancaRepository;

@Controller
@RequestMapping("/testeT")
public class BancaController {
	
	@Autowired
    private BancaRepository bancaRepository;
	
//	@RequestMapping(value="/developers",method=RequestMethod.POST)
//	public String developersAdd(@RequestParam String email, 
//						@RequestParam String firstName, @RequestParam String lastName, Model model) {
//		Developer newDeveloper = new Developer();
//		newDeveloper.setEmail(email);
//		newDeveloper.setFirstName(firstName);
//		newDeveloper.setLastName(lastName);
//		repository.save(newDeveloper);
//
//		model.addAttribute("developer", newDeveloper);
//		model.addAttribute("skills", skillRepository.findAll());
//		return "redirect:/developer/" + newDeveloper.getId();
//	}
	
	
	
	 @RequestMapping(value= "/bancaT", method=RequestMethod.POST)
	    public String createBanca(@RequestParam String descricao,Model model) {
			Banca newBanca = new Banca();
			newBanca.setDescricao(descricao);
			bancaRepository.save(newBanca);
	        model.addAttribute("banca", newBanca);
	        return "Sucesso ! ! !";
	    }
	 

//	    @PostMapping("/bancaT")
//	    public String bancaSubmit(Banca banca) {
//	      
//	    	return "Login";
//	    }
}
