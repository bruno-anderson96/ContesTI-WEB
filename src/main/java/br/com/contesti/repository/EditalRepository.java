package br.com.contesti.repository;

import java.util.List;

import org.springframework.dao.DataAccessException;

import br.com.contesti.entidades.Edital;

public interface EditalRepository {

	List<Edital> findByEditalId(Integer idEdital);

	Edital findByid(int idEdital) throws DataAccessException;
	
	void save(Edital edital) throws DataAccessException;
	
	
}
