package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Permissoes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3038658650505964134L;

	@Id
	@GeneratedValue
	private Integer idPermissoes;
	
	@Column(nullable=true, length=45)
	private String permissao;
	
	@ManyToOne
	private Usuario usuario;
	
	public Integer getIdPermissoes() {
		return idPermissoes;
	}
	public void setIdPermissoes(Integer idPermissoes) {
		this.idPermissoes = idPermissoes;
	}
	public String getPermissao() {
		return permissao;
	}
	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((permissao == null) ? 0 : permissao.hashCode());
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
		Permissoes other = (Permissoes) obj;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Permissoes [idPermissoes=" + idPermissoes + ", permissao=" + permissao + "]";
	}
	
	
	
}
