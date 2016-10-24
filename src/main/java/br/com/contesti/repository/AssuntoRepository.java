package br.com.contesti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contesti.entidades.Assunto;

public interface AssuntoRepository  extends JpaRepository<Assunto, Long> {

}
