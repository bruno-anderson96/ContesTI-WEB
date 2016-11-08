package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4557327474797890761L;
	@Id

	@Column(name = "role",columnDefinition="VARCHAR(64)")	
	@Size(min=1,message="Preencha o campo permissão")
	private String role;

	private String descricao;
	
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Role(String role, String descricao) {
		super();
		this.role = role;
		this.descricao = descricao;
	}
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
