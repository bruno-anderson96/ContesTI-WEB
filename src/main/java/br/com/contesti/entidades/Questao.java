package br.com.contesti.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Questao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1122050260113866970L;
	
	public Questao(String pergunta, String comentario, int ano){
		this.pergunta =pergunta;
		this.comentario = comentario;
		this.ano = ano;
	}
	
	@Id
	@GeneratedValue
	private Integer idQuestao;
	
	@Column(nullable=true)
	private String pergunta;
	
	@Column(nullable=true, length=255)
	private String comentario;
	
	
	@Column(nullable=true, length=11)
	private int ano;	
	
	@ManyToOne
	private Assunto assunto;
	
	public Integer getIdQuestao() {
		return idQuestao;
	}
	public void setIdQuestao(Integer idQuestao) {
		this.idQuestao = idQuestao;
	}
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public int getAno() {
		return ano;
	}
	public void setAno(int ano) {
		this.ano = ano;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ano;
		result = prime * result + ((comentario == null) ? 0 : comentario.hashCode());
		result = prime * result + ((idQuestao == null) ? 0 : idQuestao.hashCode());
		result = prime * result + ((pergunta == null) ? 0 : pergunta.hashCode());
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
		Questao other = (Questao) obj;
		if (ano != other.ano)
			return false;
		if (comentario == null) {
			if (other.comentario != null)
				return false;
		} else if (!comentario.equals(other.comentario))
			return false;
		if (idQuestao == null) {
			if (other.idQuestao != null)
				return false;
		} else if (!idQuestao.equals(other.idQuestao))
			return false;
		if (pergunta == null) {
			if (other.pergunta != null)
				return false;
		} else if (!pergunta.equals(other.pergunta))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Questao [idQuestao=" + idQuestao + ", pergunta=" + pergunta + ", comentario=" + comentario + ", ano="
				+ ano + "]";
	}
	

	
	
	
	
	
	
	
}
