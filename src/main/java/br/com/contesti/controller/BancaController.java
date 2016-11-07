package br.com.contesti.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.contesti.entidades.Banca;
import br.com.contesti.repository.BancaRepository;

@Controller
@RequestMapping("/banca")
public class BancaController {

	@Autowired
	private BancaRepository bancaRepository;

	// @RequestMapping(value="/developers",method=RequestMethod.POST)
	// public String developersAdd(@RequestParam String email,
	// @RequestParam String firstName, @RequestParam String lastName, Model
	// model) {
	// Developer newDeveloper = new Developer();
	// newDeveloper.setEmail(email);
	// newDeveloper.setFirstName(firstName);
	// newDeveloper.setLastName(lastName);
	// repository.save(newDeveloper);
	//
	// model.addAttribute("developer", newDeveloper);
	// model.addAttribute("skills", skillRepository.findAll());
	// return "redirect:/developer/" + newDeveloper.getId();
	// }

	@RequestMapping(value = "/criarBanca", method = RequestMethod.POST)
	@ResponseBody  
	public ModelAndView createBanca(@RequestParam String descricao,RedirectAttributes attributes,
			 @Valid Banca banca,BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/homeAdm");
if(result.hasFieldErrors("descricao")){
	
	attributes.addFlashAttribute("erro", "Preencha o campo Banca");
	return mv;
}else{
		
		bancaRepository.save(banca);
		
		attributes.addFlashAttribute("mensagem", "Banca adicionada!");
		return mv;

	}
	}
}

	// @PostMapping("/bancaT")
	// public String bancaSubmit(Banca banca) {
	//
	// return "Login";
	// }

