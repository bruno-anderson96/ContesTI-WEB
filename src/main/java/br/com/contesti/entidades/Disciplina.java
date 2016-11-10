package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="disciplina")
public class Disciplina implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1167215334015066636L;
	
	public Disciplina(String descricao){
		this.descricao = descricao;
	}
		
	public Disciplina() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Id
	@GeneratedValue
	private Long idDisciplina;
	
	@Size(min=1,message="Preencha o campo Disciplina")
	@Column(nullable=true, length=150)
	private String descricao;

	public Long getId() {
		return idDisciplina;
	}

	public void setId(Long id) {
		this.idDisciplina = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idDisciplina == null) ? 0 : idDisciplina.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idDisciplina == null) {
			if (other.idDisciplina != null)
				return false;
		} else if (!idDisciplina.equals(other.idDisciplina))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Disciplina [id=" + idDisciplina + ", descricao=" + descricao + "]";
	}
}
