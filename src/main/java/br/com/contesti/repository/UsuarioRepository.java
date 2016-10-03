package br.com.contesti.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.contesti.entidades.Usuario;

public interface UsuarioRepository {

	List<Usuario> findByUsuarioId(Integer idUsuario);

	Usuario findByid(int id) throws DataAccessException;
	
	void save(Usuario usuario) throws DataAccessException;
	
}
