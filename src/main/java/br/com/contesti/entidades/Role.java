package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Role implements Serializable {

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
