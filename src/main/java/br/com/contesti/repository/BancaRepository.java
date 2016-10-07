package br.com.contesti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contesti.entidades.Banca;

public interface BancaRepository extends JpaRepository<Banca, Long> {

	
	List<Banca> findByDescricao(String descricao);

}
