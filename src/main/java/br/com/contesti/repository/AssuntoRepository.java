package br.com.contesti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contesti.entidades.Assunto;
import br.com.contesti.entidades.Disciplina;

public interface AssuntoRepository  extends JpaRepository<Assunto, Long> {

	Assunto findByDisciplina(Disciplina disciplina);
	
	
}
