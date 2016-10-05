package br.com.contesti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contesti.entidades.Questao;

public interface QuestaoRepository extends JpaRepository<Questao, Long> {

	
	List<Questao> findByPergunta(String pergunta);
	

	
	
}
