/**
 * 
 */
package br.com.lab.model;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author Wellington
 *
 */
public class Login implements Serializable{


	private static final long serialVersionUID = 1L;
	
	private int id;
	private String nome;
	private String email;
	private String senha;
	
	/**
	 * 
	 */
	public Login() {
		// TODO Auto-generated constructor stub
	}

	public Login(int id, String nome, String email, String senha) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return id == other.id;
	}
	
	

}
