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

import br.com.contesti.entidades.Assunto;
import br.com.contesti.entidades.Disciplina;
import br.com.contesti.repository.AssuntoRepository;
import br.com.contesti.repository.DisciplinaRepository;

@Controller
@RequestMapping("/assunto")
public class AssuntoController {

	@Autowired
	private AssuntoRepository assuntoRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@RequestMapping(value = "/criarAssunto", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView createAssunto(@RequestParam Disciplina disciplina, @RequestParam String descricao,
			RedirectAttributes attributes, @Valid Assunto assunto, BindingResult result) {
		ModelAndView mv = new ModelAndView("redirect:/homeAdm");

		disciplina = disciplinaRepository.findOne(disciplina.getId());
		if (disciplinaRepository.findOne(disciplina.getId()) == null) {

			attributes.addFlashAttribute("erro", "Selecione a disciplina");
			return mv;
		} else {

			if (result.hasFieldErrors("descricao")) {

				attributes.addFlashAttribute("erro", "Preencha o campo Assunto");
				return mv;

			} else {
				assuntoRepository.save(new Assunto(descricao, disciplina));
				attributes.addFlashAttribute("mensagem", "Assunto adicionado");
				return mv;
			}
		}
	}
}