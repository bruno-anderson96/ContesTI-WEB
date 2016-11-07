package br.com.contesti.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.contesti.entidades.Role;

public interface RoleRepository  extends JpaRepository<Role, Long> {

}
