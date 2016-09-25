package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Edital implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4828052666371151961L;

	@Id
	@GeneratedValue
	private Integer idEdital;
	
	@Column(nullable=true, length=45)
	private String nome;
	
	
	@Column(nullable=true, length=255)
	private String link;
	
	@ManyToOne
	private Banca banca;
	
	public Integer getIdEdital() {
		return idEdital;
	}
	public void setIdEdital(Integer idEdital) {
		this.idEdital = idEdital;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEdital == null) ? 0 : idEdital.hashCode());
		result = prime * result + ((link == null) ? 0 : link.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Edital other = (Edital) obj;
		if (idEdital == null) {
			if (other.idEdital != null)
				return false;
		} else if (!idEdital.equals(other.idEdital))
			return false;
		if (link == null) {
			if (other.link != null)
				return false;
		} else if (!link.equals(other.link))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Edital [idEdital=" + idEdital + ", nome=" + nome + ", link=" + link + "]";
	}
	
	
	
}
