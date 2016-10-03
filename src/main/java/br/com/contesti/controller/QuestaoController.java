package br.com.contesti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.contesti.entidades.Questao;
import br.com.contesti.repository.QuestaoRepository;

@Controller
@RequestMapping("/CadastroQuestao")
public class QuestaoController {

    private QuestaoRepository questaoRepository;
    
    @Autowired
    public QuestaoController( QuestaoRepository questaoRepository) {
          this.questaoRepository = questaoRepository;
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
    public String adicionaQuestaoBanca(@PathVariable("pergunta") String pergunta, Questao questao) {
          questao.setPergunta(pergunta);
          questaoRepository.save(questao);
          return "redirect:/{pergunta}";
    }
    
    

}
