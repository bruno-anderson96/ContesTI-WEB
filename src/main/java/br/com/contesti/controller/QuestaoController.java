package br.com.contesti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.contesti.entidades.Alternativa;
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
	

	@RequestMapping(value = "/teste")
    @ResponseBody  
    public String create(String pergunta, String comentario, Integer ano, String descricao, Boolean correta){	
		
		System.out.println("ANTES DO TRY");
    	try{    
    		
    		System.out.println("NO TRY");
    		Questao q1 = new Questao("pergunta","comentario",1996);
    		Alternativa a1 = new Alternativa("reposta", false, q1);
     		questaoRepository.save(q1);
     		alternativaRepository.save(a1);
//     		alternativaRepository.save(new Alternativa("alternativa1", false, questao));
       	}catch(Exception ex){
    		System.out.println("EXCEÇÃO");
    		return "Error" + ex.toString();
    	}
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



