package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Alternativa implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4793798064584755463L;
	
	public Alternativa(String descricao, boolean correta, Questao questao){
		this.descricao = descricao;
		this.correta = correta;
		this.questao = questao;
	}	
	
	public Alternativa() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue
	private Integer idAlternativa;
	
	@Size(min=1,message="Preencha todas as alternativas")
	@Column(nullable=true, length=100)
	private String descricao;
	
	@NotNull(message="Preencha a alternativa correta")
	@Column(nullable=true)
	private boolean correta;
	
	@ManyToOne
	private Questao questao;	
	
	
	public Integer getId() {
		return idAlternativa;
	}
	public void setId(Integer id) {
		this.idAlternativa = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public boolean isCorreta() {
		return correta;
	}
	public void setCorreta(boolean correta) {
		this.correta = correta;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (correta ? 1231 : 1237);
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((idAlternativa == null) ? 0 : idAlternativa.hashCode());
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
		Alternativa other = (Alternativa) obj;
		if (correta != other.correta)
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (idAlternativa == null) {
			if (other.idAlternativa != null)
				return false;
		} else if (!idAlternativa.equals(other.idAlternativa))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Alternativa [id=" + idAlternativa + ", descricao=" + descricao + ", correta=" + correta + "]";
	}
	
	
	
	
	
	

}
