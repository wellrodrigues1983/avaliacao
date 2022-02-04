/**
 * 
 */
package br.com.lab.beans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import br.com.lab.model.DAO;
import br.com.lab.model.Login;
import br.com.lab.model.Paciente;

/**
 * @author Wellington
 *
 */
@ManagedBean
@SessionScoped
public class PacienteMB {
	
	public Paciente paciente;
	
	public List<Paciente> listaPaciente = new ArrayList<Paciente>();

	DAO dao = new DAO();
	
	Login login = new Login();

	@PostConstruct
	public List<Paciente> getListaPaciente() {
		listaPaciente = dao.listarPessoas();
		return listaPaciente;
	}
	
	private boolean autenticado = false;

	public String isAutenticado(Login login) {
		login.getEmail();
		login.getSenha();
		dao.loginAuth(login);
		return "/avaliacao/entrar.xhtml";
	}

	public void setAutenticado(boolean autenticado) {
		this.autenticado = autenticado;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}


}
