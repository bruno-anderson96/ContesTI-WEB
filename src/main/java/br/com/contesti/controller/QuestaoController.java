package br.com.contesti.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.contesti.entidades.Alternativa;
import br.com.contesti.entidades.Assunto;
import br.com.contesti.entidades.Disciplina;
import br.com.contesti.entidades.Questao;
import br.com.contesti.repository.AlternativaRepository;
import br.com.contesti.repository.AssuntoRepository;
import br.com.contesti.repository.DisciplinaRepository;
import br.com.contesti.repository.QuestaoRepository;

@Controller
@RequestMapping("/cadastroQuestaoUsuario")
public class QuestaoController {

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private AlternativaRepository alternativaRepository;

	@Autowired
	private DisciplinaRepository disciplinaRepository;

	@Autowired
	private AssuntoRepository assuntoRepository;

	@RequestMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Assunto> pesquisarPorId(
			@RequestParam(name = "disciplina", defaultValue = "-1") Long codigoDisciplina) {
		return assuntoRepository.findByDisciplinaIdDisciplina(codigoDisciplina);
	}

	@RequestMapping(value = "/criarQuestaoUsuario", method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView create(@RequestParam String pergunta,
			@RequestParam(name = "isCorreta", defaultValue = "") String isCorreta, Boolean correta1, Boolean correta2,
			Boolean correta3, Boolean correta4, Boolean correta5, @RequestParam String desc1,
			@RequestParam String desc2, @RequestParam String desc3, @RequestParam String desc4,
			@RequestParam String desc5, @RequestParam Disciplina disciplina,
			@RequestParam(name = "assuntoDescricao", defaultValue = "") String assuntoDescricao, @Valid Questao questao,
			Model model, RedirectAttributes attributes, BindingResult result) {

		ModelAndView mv = new ModelAndView("redirect:/cadastroQuestaoUsuario");

		if (assuntoDescricao.isEmpty()) {
			attributes.addFlashAttribute("erro", "Selecione um assunto");
			return mv;
		} else

		if (pergunta.isEmpty()) {
			attributes.addFlashAttribute("erro", "Preencha o campo Pergunta");
			return mv;
		} else if (desc1.isEmpty() || desc2.isEmpty() || desc3.isEmpty() || desc4.isEmpty() || desc5.isEmpty()) {
			attributes.addFlashAttribute("erro", "Preencha todas as alternativas");

			return mv;
		} else if (isCorreta.isEmpty()) {
			attributes.addFlashAttribute("erro", "Preencha a alternativa correta");

			return mv;
		} else {

			if (isCorreta.equals("A")) {
				correta1 = true;
			} else {
				correta1 = false;
			}
			if (isCorreta.equals("B")) {
				correta2 = true;
			} else {
				correta2 = false;
			}
			if (isCorreta.equals("C")) {
				correta3 = true;
			} else {
				correta3 = false;
			}
			if (isCorreta.equals("D")) {
				correta4 = true;
			} else {
				correta4 = false;
			}
			if (isCorreta.equals("E")) {
				correta5 = true;
			} else {
				correta5 = false;
			}

			disciplina = disciplinaRepository.findOne(disciplina.getId());
			Assunto assunto = assuntoRepository.findByDescricao(assuntoDescricao);

			questao = new Questao(pergunta, questao, assunto);
			questaoRepository.save(questao);

			Alternativa a1 = new Alternativa(desc1, correta1, questao);
			Alternativa a2 = new Alternativa(desc2, correta2, questao);
			Alternativa a3 = new Alternativa(desc3, correta3, questao);
			Alternativa a4 = new Alternativa(desc4, correta4, questao);
			Alternativa a5 = new Alternativa(desc5, correta5, questao);
			alternativaRepository.save(a1);
			alternativaRepository.save(a2);
			alternativaRepository.save(a3);
			alternativaRepository.save(a4);
			alternativaRepository.save(a5);

			attributes.addFlashAttribute("mensagem", "Questão cadastrada com sucesso!");
			return mv;
		}
	}
}
