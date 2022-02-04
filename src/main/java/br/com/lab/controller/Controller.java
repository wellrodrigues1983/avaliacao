package br.com.lab.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.lab.beans.PacienteMB;
import br.com.lab.model.DAO;
import br.com.lab.model.Login;
import br.com.lab.model.Paciente;

@WebServlet(urlPatterns = { "/controller", "/save", "/select", "/update", "/delete", "/login", "/logout" })
public class Controller extends HttpServlet {

	private static final long serialVersionUID = 1L;

	DAO dao = new DAO();

	Paciente paciente = new Paciente();

	Gson gson = new Gson();
	
	Boolean auth = false;
	
	Login login = new Login();
	
	private List<Login> logar = new ArrayList<Login>();
	
	PacienteMB pacienteMB;

	public Controller() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getServletPath();
		System.out.println(action);

		if (action.equals("/save")) {
			salvarPaciente(request, response);
		} else if (action.equals("/select")) {
			listarContato(request, response);
		} else if (action.equals("/update")) {
			editarContato(request, response);
		} else if (action.equals("/delete")) {
			removerContato(request, response);
		} else if (action.equals("/login")) {
			login(request, response);
		} else if (action.equals("/logout")) {
			logout(request, response);
		} else {
			listaJson(request, response);
		}

	}

	/**
	 * @param request
	 * @param response
	 */
	private void logout(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException 
	 */
	private void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		login.setEmail(request.getParameter("username"));
		login.setNome(request.getParameter("password"));
		
		
		dao.loginAuth(login);
		
		if (dao.loginAuth(login).size() > 0) {
			auth = true;
			
			System.out.println(auth);
			
			response.sendRedirect("/avaliacao/index.xhtml");
		}
	}

	/**
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	private void listaJson(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		resp.setContentType("application/gson");
		resp.setCharacterEncoding("utf-8");
		resp.setStatus(200);

		PrintWriter pw = resp.getWriter();
		pw.print(gson.toJson(dao.listarPessoas()));
		pw.flush();

	}

	// Listar Todos
	private void listarContato(HttpServletRequest request, HttpServletResponse response) throws IOException {
		ArrayList<Paciente> lista = dao.listarPessoas();

	}

	protected void salvarPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// variaveis Paciente
		paciente.setNome(request.getParameter("nome"));
		paciente.setNumAcesso(request.getParameter("numAcesso"));
		paciente.setVisita(request.getParameter("visita"));
		paciente.setPatientID(request.getParameter("patientID"));
		paciente.setData(request.getParameter("data"));
		paciente.setModalidade(request.getParameter("modalidade"));
		paciente.setTipoExame(request.getParameter("tipoExame"));
		paciente.setNumero(request.getParameter("numero"));
		paciente.setEstado(request.getParameter("estado"));
		paciente.setMedSol(request.getParameter("medSol"));
		paciente.setLaudo(request.getParameter("laudo"));
		paciente.setSexo(request.getParameter("sexo"));
		paciente.setEspecial(request.getParameter("especial"));
		paciente.setUrgente(request.getParameter("urgente"));
		paciente.setRestaurado(request.getParameter("restaurado"));

		dao.inserirPessoa(paciente);

	}

	private void removerContato(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private void editarContato(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/gson");
		resp.setCharacterEncoding("utf-8");
		req.setCharacterEncoding("utf-8");
		resp.setStatus(201); // created

		StringBuffer sb = new StringBuffer();
		BufferedReader br = req.getReader();

		String atributos = null;

		while ((atributos = br.readLine()) != null) {
			sb.append(atributos);
		}

		paciente = gson.fromJson(sb.toString(), Paciente.class);

		PrintWriter pw = resp.getWriter();
		pw.print(gson.toJson(dao.inserirPessoa(paciente)));
		pw.flush();

	}

}
