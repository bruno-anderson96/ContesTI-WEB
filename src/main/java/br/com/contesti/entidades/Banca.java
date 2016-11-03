package br.com.contesti.entidades;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
public class Banca implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3768754843159192680L;

	public Banca(String descricao){
		this.descricao = descricao;
	}
	public Banca(){
		
	}
	
	@Id
	@GeneratedValue
	private Long idBanca;
	@Column(nullable=true, length=100)
	@NotNull(message="Preencha o campo banca")
	private String descricao;
	public Long getId() {
		return idBanca;
	}
	public void setId(Long id) {
		this.idBanca = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idBanca == null) ? 0 : idBanca.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Banca other = (Banca) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idBanca == null) {
			if (other.idBanca != null)
				return false;
		} else if (!idBanca.equals(other.idBanca))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Banca [id=" + idBanca + ", descricao=" + descricao + "]";
	}
	
	
}
