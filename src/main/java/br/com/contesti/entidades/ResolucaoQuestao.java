package br.com.contesti.entidades;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

public class ResolucaoQuestao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 70709647454840591L;

	@Id
	@GeneratedValue
	private Integer idResolucaoQuestao;
	
	@Column(nullable=true)
	private Date dataq;
	
	@Column(nullable=true, length = 1)
	private Boolean acerto;
	
	@ManyToOne
	private Questao questao;
	
	@ManyToOne
	private Usuario usuario;
	
	
	public Integer getIdResolucaoQuestao() {
		return idResolucaoQuestao;
	}
	public void setIdResolucaoQuestao(Integer idResolucaoQuestao) {
		this.idResolucaoQuestao = idResolucaoQuestao;
	}
	public Date getDataq() {
		return dataq;
	}
	public void setDataq(Date dataq) {
		this.dataq = dataq;
	}
	public Boolean getAcerto() {
		return acerto;
	}
	public void setAcerto(Boolean acerto) {
		this.acerto = acerto;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acerto == null) ? 0 : acerto.hashCode());
		result = prime * result + ((dataq == null) ? 0 : dataq.hashCode());
		result = prime * result + ((idResolucaoQuestao == null) ? 0 : idResolucaoQuestao.hashCode());
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
		ResolucaoQuestao other = (ResolucaoQuestao) obj;
		if (acerto == null) {
			if (other.acerto != null)
				return false;
		} else if (!acerto.equals(other.acerto))
			return false;
		if (dataq == null) {
			if (other.dataq != null)
				return false;
		} else if (!dataq.equals(other.dataq))
			return false;
		if (idResolucaoQuestao == null) {
			if (other.idResolucaoQuestao != null)
				return false;
		} else if (!idResolucaoQuestao.equals(other.idResolucaoQuestao))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "resolucaoQuestao [idResolucaoQuestao=" + idResolucaoQuestao + ", dataq=" + dataq + ", acerto=" + acerto
				+ "]";
	}
	
	

	
	
}
