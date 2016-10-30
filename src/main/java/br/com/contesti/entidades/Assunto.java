package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Assunto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9134132860303958115L;
	
	public Assunto(String descricao, Disciplina disciplina){
		this.descricao = descricao;
		this.disciplina = disciplina;
	}
	
	public Assunto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private Long idAssunto;
	
	@Column(nullable=true, length=150)
	private String descricao;
	
	@ManyToOne
	private Disciplina disciplina;
	
	
	
	
	public Long getId() {
		return idAssunto;
	}
	public void setId(Long id) {
		this.idAssunto = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result
				+ ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((idAssunto == null) ? 0 : idAssunto.hashCode());
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
		Assunto other = (Assunto) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (idAssunto == null) {
			if (other.idAssunto != null)
				return false;
		} else if (!idAssunto.equals(other.idAssunto))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Assunto [id=" + idAssunto + ", descricao=" + descricao
				+ ", disciplina=" + disciplina + "]";
	}
	
	

}
