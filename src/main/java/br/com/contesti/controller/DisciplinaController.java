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

import br.com.contesti.entidades.Disciplina;
import br.com.contesti.repository.DisciplinaRepository;

@Controller
@RequestMapping("/disciplina")
public class DisciplinaController {

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@RequestMapping(value = "/criarDisciplina", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createBanca(@RequestParam String descricao, RedirectAttributes attributes,
			@Valid Disciplina disciplina, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/homeAdm");
		if (result.hasFieldErrors("descricao")) {

			attributes.addFlashAttribute("erro", "Preencha o campo Disciplina");
			return mv;
		} else {

			disciplinaRepository.save(disciplina);

			attributes.addFlashAttribute("mensagem", "Disciplina adicionada!");
			return mv;

		}
	}
}
