package br.com.contesti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contesti.entidades.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByLogin(String login);
	
		
}
