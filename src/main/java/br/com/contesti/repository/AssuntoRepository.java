package br.com.contesti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contesti.entidades.Assunto;
import br.com.contesti.entidades.Disciplina;

public interface AssuntoRepository  extends JpaRepository<Assunto, Long> {

	
	public List<Assunto> findByDisciplinaIdDisciplina(Long IdDisciplina);
	
	public Assunto findByDescricao(String descricao);
	
}
