package br.com.contesti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.contesti.entidades.Alternativa;
import br.com.contesti.entidades.Questao;
import br.com.contesti.repository.QuestaoRepository;
import br.com.contesti.repository.AlternativaRepository;

@Controller
@RequestMapping("/CadastroQuestao")
public class QuestaoController {

    private QuestaoRepository questaoRepository;
    private AlternativaRepository alternativaRepository;
    
    @Autowired
    public QuestaoController( QuestaoRepository questaoRepository, AlternativaRepository alternativaRepository) {
          this.questaoRepository = questaoRepository;
          this.alternativaRepository = alternativaRepository;
    }
   
    

    @RequestMapping(value = "/{pergunta}", method = RequestMethod.GET)
    public String listaQuestao(@PathVariable("pergunta") String pergunta, Model model) {
          List<Questao> listaQuestao = questaoRepository.findByPergunta(pergunta);
          if (listaQuestao != null) {
                model.addAttribute("Questao", listaQuestao);
          }
          return "listaQuestao";
    }

    @RequestMapping(value = "/{pergunta}", method = RequestMethod.POST)
    public String adicionaQuestaoBanca(@PathVariable("pergunta") String descricao, String pergunta, Questao questao, Alternativa a1,Alternativa a2,Alternativa a3,Alternativa a4,Alternativa a5) {
          a1.setDescricao(descricao);
    	  questao.setPergunta(pergunta);
          questaoRepository.save(questao);
          return "redirect:/{pergunta}";
    }
    
    @RequestMapping(value = "/teste", method = RequestMethod.POST)
    public String adicionaQuestao(@PathVariable("teste") Questao questao,
    		Alternativa a1,Alternativa a2,Alternativa a3,Alternativa a4,Alternativa a5
    		 ){
    		questao.setPergunta("pergunta");
    		questao.setAno(1996);
    		questao.setComentario("nova");
    		
    	a1.setDescricao("a1");
    	a1.setCorreta(true);
    	
    	a2.setDescricao("a2");
    	a2.setCorreta(false);
    	a3.setDescricao("a3");
    	a3.setCorreta(false);
    	a4.setDescricao("a4");
    	a4.setCorreta(false);
    	a5.setDescricao("a5");
    	a5.setCorreta(false);
    	
    	questaoRepository.save(questao);
    	alternativaRepository.save(a1);
    	alternativaRepository.save(a2);
    	alternativaRepository.save(a3);
    	alternativaRepository.save(a4);
    	alternativaRepository.save(a5);
    	
   
    		
    	
    		return "redirect:/(teste)";
    }
    }
    


