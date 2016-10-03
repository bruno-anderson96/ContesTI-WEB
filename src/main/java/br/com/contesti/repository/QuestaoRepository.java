package br.com.contesti.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.contesti.entidades.Questao;

public interface QuestaoRepository {

	
	List<Questao> findByQuestaoId(Integer idQuestao);

	Questao findByid(int idQuestao) throws DataAccessException;
	Questao findByDisciplina(String disciplina) throws DataAccessException;
	Questao findByBanca(String banca) throws DataAccessException;
	Questao findByAssunto(String assunto) throws DataAccessException;
	
	void save(Questao questao) throws DataAccessException;
	
}
