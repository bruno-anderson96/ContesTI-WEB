package br.com.contesti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contesti.entidades.Alternativa;
import br.com.contesti.entidades.Banca;
import br.com.contesti.entidades.Questao;
import br.com.contesti.repository.AlternativaRepository;
import br.com.contesti.repository.QuestaoRepository;

@Controller
@RequestMapping("/cadastroQuestao")
public class QuestaoController {

	
	
	@Autowired
    private QuestaoRepository questaoRepository;

	@Autowired
	private AlternativaRepository alternativaRepository;
	

//
//	 @RequestMapping(value= "/bancaT", method=RequestMethod.POST)
//	    public String createBanca(@RequestParam String descricao,Model model) {
//			Banca newBanca = new Banca();
//			newBanca.setDescricao(descricao);
//			bancaRepository.save(newBanca);
//	        model.addAttribute("banca", newBanca);
//	        return "Sucesso ! ! !";
//	    }
	
	
	
	@RequestMapping(value = "/criarQuestao", method=RequestMethod.POST)
    @ResponseBody  
    public String create(@RequestParam String pergunta,
    					 @RequestParam Boolean correta,
    					 @RequestParam String desc1,@RequestParam String desc2,@RequestParam String desc3,
    					 @RequestParam String desc4,@RequestParam String desc5, Questao questao,
    					 Model model){	
		
    		
    		questao.setPergunta(pergunta);
    		
    
  
     		questaoRepository.save(questao);
    		alternativaRepository.save(new Alternativa(desc1, false,  questao));
    		alternativaRepository.save(new Alternativa(desc2, false,  questao));
    		alternativaRepository.save(new Alternativa(desc3, false,  questao));
    		alternativaRepository.save(new Alternativa(desc4, false,  questao));
    		alternativaRepository.save(new Alternativa(desc5, false,  questao));

       	
    	return "Sucesso!!!";
      
    }
 

}

    
//private AlternativaRepository alternativaRepository;


//public QuestaoController( QuestaoRepository questaoRepository) {
//    this.questaoRepository = questaoRepository;
////    this.alternativaRepository = alternativaRepository;
//}


//
//@RequestMapping(value = "/{pergunta}", method = RequestMethod.GET)
//public String listaQuestao(@PathVariable("pergunta") String pergunta, Model model) {
//    List<Questao> listaQuestao = questaoRepository.findByPergunta(pergunta);
//    if (listaQuestao != null) {
//          model.addAttribute("Questao", listaQuestao);
//    }
//    return "listaQuestao";
//}
//
//@RequestMapping(value = "/{pergunta}", method = RequestMethod.POST)
//public String adicionaQuestaoBanca(@PathVariable("pergunta") String descricao, String pergunta, Questao questao, Alternativa a1,Alternativa a2,Alternativa a3,Alternativa a4,Alternativa a5) {
//    a1.setDescricao(descricao);
//	  questao.setPergunta(pergunta);
//    questaoRepository.save(questao);
//    return "redirect:/{pergunta}";
//}



