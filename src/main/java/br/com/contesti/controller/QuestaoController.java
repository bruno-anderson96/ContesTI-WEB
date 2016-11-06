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

import br.com.contesti.entidades.Alternativa;
import br.com.contesti.entidades.Assunto;
import br.com.contesti.entidades.Banca;
import br.com.contesti.entidades.Disciplina;
import br.com.contesti.entidades.Questao;
import br.com.contesti.repository.AlternativaRepository;
import br.com.contesti.repository.AssuntoRepository;
import br.com.contesti.repository.BancaRepository;
import br.com.contesti.repository.DisciplinaRepository;
import br.com.contesti.repository.QuestaoRepository;

@Controller
@RequestMapping("/cadastroQuestao")
public class QuestaoController {

	@Autowired
	private QuestaoRepository questaoRepository;

	@Autowired
	private AlternativaRepository alternativaRepository;
	
	@Autowired
	private DisciplinaRepository disciplinaRepository;
	
	@Autowired
	private AssuntoRepository assuntoRepository;
	
	@Autowired
	private BancaRepository bancaRepository;

	// testes
	// @RequestMapping(value= "/bancaT", method=RequestMethod.POST)
	// public String createBanca(@RequestParam String descricao,Model model) {
	// Banca newBanca = new Banca();
	// newBanca.setDescricao(descricao);
	// bancaRepository.save(newBanca);
	// model.addAttribute("banca", newBanca);
	// return "Sucesso ! ! !";
	// }

	@RequestMapping(value = "/criarQuestaoUsuario", method = RequestMethod.POST)
	@ResponseBody
	public String create(@RequestParam String pergunta, @RequestParam String isCorreta, Boolean correta1,
			Boolean correta2, Boolean correta3, Boolean correta4, Boolean correta5, @RequestParam String desc1,
			@RequestParam String desc2, @RequestParam String desc3, @RequestParam String desc4,
			@RequestParam String desc5, @RequestParam Disciplina disciplina ,@RequestParam Assunto assunto,
			@Valid Questao questao, Model model,BindingResult result) {

				
		if (isCorreta.equals("A")) {
			correta1 = true;
		} else {
			correta1 = false;
		}
		if(isCorreta.equals("B")) {
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
	    assunto = assuntoRepository.findOne(assunto.getId());    
	    

		
	    questao = new Questao(pergunta,questao,assunto);
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

		return "Sucesso!!!";

	}
	@RequestMapping(value = "/criarQuestaoConcurso", method = RequestMethod.POST)
	@ResponseBody
	public String createConcurso(@RequestParam String pergunta, @RequestParam String isCorreta, Boolean correta1,
			Boolean correta2, Boolean correta3, Boolean correta4, Boolean correta5, @RequestParam String desc1,
			@RequestParam String desc2, @RequestParam String desc3, @RequestParam String desc4,
			@RequestParam String desc5, 
			@RequestParam Disciplina disciplina,@RequestParam Assunto assunto, @RequestParam Banca banca,
			Questao questao,Model model) {

		
		
		if (isCorreta.equals("A")) {
			correta1 = true;
		} else {
			correta1 = false;
		}
		if(isCorreta.equals("B")) {
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

		questao.setPergunta(pergunta);
		
		banca = bancaRepository.findOne(banca.getId());
	    disciplina = disciplinaRepository.findOne(disciplina.getId());
	    assunto = assuntoRepository.findOne(assunto.getId());    
	    
		
		
	    questao = questaoRepository.save(new Questao(questao.getPergunta(), assunto, banca));
		
		alternativaRepository.save(new Alternativa(desc1, correta1, questao));
		alternativaRepository.save(new Alternativa(desc2, correta2, questao));
		alternativaRepository.save(new Alternativa(desc3, correta3, questao));
		alternativaRepository.save(new Alternativa(desc4, correta4, questao));
		alternativaRepository.save(new Alternativa(desc5, correta5, questao));

		return "Sucesso!!!";

	}

}

// private AlternativaRepository alternativaRepository;

// public QuestaoController( QuestaoRepository questaoRepository) {
// this.questaoRepository = questaoRepository;
//// this.alternativaRepository = alternativaRepository;
// }

//
// @RequestMapping(value = "/{pergunta}", method = RequestMethod.GET)
// public String listaQuestao(@PathVariable("pergunta") String pergunta, Model
// model) {
// List<Questao> listaQuestao = questaoRepository.findByPergunta(pergunta);
// if (listaQuestao != null) {
// model.addAttribute("Questao", listaQuestao);
// }
// return "listaQuestao";
// }
//
// @RequestMapping(value = "/{pergunta}", method = RequestMethod.POST)
// public String adicionaQuestaoBanca(@PathVariable("pergunta") String
// descricao, String pergunta, Questao questao, Alternativa a1,Alternativa
// a2,Alternativa a3,Alternativa a4,Alternativa a5) {
// a1.setDescricao(descricao);
// questao.setPergunta(pergunta);
// questaoRepository.save(questao);
// return "redirect:/{pergunta}";
// }
