package br.com.contesti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import br.com.contesti.entidades.Banca;
import br.com.contesti.repository.BancaRepository;

@Controller
@RequestMapping("/testeT")
public class BancaController {
	
	@Autowired
    private BancaRepository bancaRepository;
	
	 @GetMapping("/bancaT")
	    public String createBanca(Model model) {
	        model.addAttribute("banca", new Banca());
	        return "Login";
	    }

	    @PostMapping("/bancaT")
	    public String bancaSubmit(Banca banca) {
	      
	    	return "Login";
	    }
}
