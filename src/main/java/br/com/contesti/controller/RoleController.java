package br.com.contesti.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.contesti.entidades.Role;
import br.com.contesti.repository.RoleRepository;

@Controller
@RequestMapping("/role")
public class RoleController {

	@Autowired
	private RoleRepository roleRepository;
	
	
	@RequestMapping(value = "/criarRole", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createBanca(@RequestParam String permissao, RedirectAttributes attributes, @Valid Role role,
			BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/homeAdm");
		if (result.hasFieldErrors("permissao")) {

			attributes.addFlashAttribute("erro", "Preencha o campo Permissão");
			return mv;
		} else {
			role.setRole(permissao);
			roleRepository.save(role);

			attributes.addFlashAttribute("mensagem", "Permissão adicionada!");
			return mv;

		}
	}
}
	
	

