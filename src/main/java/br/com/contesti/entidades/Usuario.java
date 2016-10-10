package br.com.contesti.entidades;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5959348604658622025L;


	@Id
	@GeneratedValue

	private Long idUsuario;
	
	@Column(nullable=true, length=30)
	private String nome_usuario;
	
	@Column(nullable=true, length=20)
	private String login;
	
	@Column(nullable=true, length=800)
	private String senha;
	
	@Column(nullable=true, length=45)
	private String email;
	
	@Column(nullable=true, length=1)
	private Boolean ativo;
	
	@ManyToMany
	@JoinTable(name="usuario_roles")
	private Collection<Role> roles;
	
	public Usuario(String nome_usuario, String login, String senha, String email, Boolean ativo) {
		// TODO Auto-generated constructor stub
		this.nome_usuario = nome_usuario;
		this.login = login;
		this.senha = senha;
		this.email = email;
		this.ativo = ativo;
	}
	
	public Usuario(){
		
	}
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getNome_usuario() {
		return nome_usuario;
	}
	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((nome_usuario == null) ? 0 : nome_usuario.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
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
		Usuario other = (Usuario) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (nome_usuario == null) {
			if (other.nome_usuario != null)
				return false;
		} else if (!nome_usuario.equals(other.nome_usuario))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nome_usuario=" + nome_usuario + ", login=" + login + ", senha="
				+ senha + ", email=" + email + "]";
	}
	
	
	
	

	
}
