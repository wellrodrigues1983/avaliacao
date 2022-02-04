/**
 * 
 */
package br.com.lab.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 *
 * @author Wellington
 */
public class DAO {
	/*
	 * Módulo de Conex�o
	 */

	// Parametros de conexão
	private String driver = "com.mysql.cj.jdbc.Driver";

	private String url = "jdbc:mysql://127.0.0.1:3306/medilab?useTimezone=true&serverTimezone=UTC";

	private String user = "root";

	private String password = "123qweasd";

	// M�todo de conex�o
	private Connection conectar() {

		Connection con = null;

		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/*
	 * CRUD CREATE
	 */
	public Paciente inserirPessoa(Paciente pessoa) {
		String create = "INSERT INTO paciente (nome,numAcesso,visita,patientID,data,modalidade,tipoExame,numero,estado,medSol,laudo,sexo,especial,urgente,restaurado) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

		try {
			// Abrir conex�o
			Connection con = conectar();

			// Preparar a query para execu��o
			PreparedStatement pst = con.prepareStatement(create);

			// Substituir Parametors pelo Conteudo das variaves JavaBeans
			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getNumAcesso());
			pst.setString(3, pessoa.getVisita());
			pst.setString(4, pessoa.getPatientID());
			pst.setString(5, pessoa.getData());
			pst.setString(6, pessoa.getModalidade());
			pst.setString(7, pessoa.getTipoExame());
			pst.setString(8, pessoa.getNumero());
			pst.setString(9, pessoa.getEstado());
			pst.setString(10, pessoa.getMedSol());
			pst.setString(11, pessoa.getLaudo());
			pst.setString(12, pessoa.getSexo());
			pst.setString(13, pessoa.getEspecial());
			pst.setString(14, pessoa.getUrgente());
			pst.setString(15, pessoa.getRestaurado());

			// Executar a query
			pst.executeUpdate();

			// Encerrar a conex�o com o banco
			pst.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return pessoa;
		
	}

	/*
	 * CRUD READ
	 */

	public ArrayList<Paciente> listarPessoas() {

		// Criando Objeto para acessar a classe Paciente
		ArrayList<Paciente> pessoa = new ArrayList<>();

		String read = "SELECT * FROM medilab.paciente ORDER BY nome";

		try {
			// Abrir conexão
			Connection con = conectar();

			// Preparar a query para execução
			PreparedStatement pst = con.prepareStatement(read);

			// Armazenar temporariamente os dados obtidos pelo pst
			ResultSet rs = pst.executeQuery();

			// O laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				// Variaveis de apoio que recebem os dados
				String id = rs.getString(1);
				String nome = rs.getString(2);
				String numAcesso = rs.getString(3);
				String visita = rs.getString(4);
				String patientID = rs.getString(5);
				String data = rs.getString(6);
				String modalidade = rs.getString(7);
				String tipoExame = rs.getString(8);
				String numero = rs.getString(9);
				String estado = rs.getString(10);
				String medSol = rs.getString(11);
				String laudo = rs.getString(12);
				String sexo = rs.getString(13);
				String especial = rs.getString(14);
				String urgente = rs.getString(15);
				String restaurado = rs.getString(16);

				// Populando o ArrayList
				pessoa.add(new Paciente(id, nome, numAcesso, visita, patientID, data, modalidade, tipoExame, numero, estado, medSol, laudo, sexo, especial, urgente, restaurado));
			}
			con.close();
			return pessoa;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	/*
	 * CRUD UPDATE
	 */

	// Selecionar o contato
	public void selecionarPaciente(Paciente contato) {
		String read2 = "SELECT * FROM paciente WHERE id = ?";

		try {
			// Abrir conexão
			Connection con = conectar();

			// Preparar a query para execu��o
			PreparedStatement pst = con.prepareStatement(read2);

			pst.setString(1, contato.getId());

			ResultSet rs = pst.executeQuery();

			while (rs.next()) {
				
				contato.setId(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setNumAcesso(rs.getString(3));
				contato.setVisita(rs.getString(4));
				contato.setPatientID(rs.getString(5));
				contato.setData(rs.getString(6));
				contato.setModalidade(rs.getString(7));
				contato.setTipoExame(rs.getString(8));
				contato.setNumero(rs.getString(9));
				contato.setEstado(rs.getString(10));
				contato.setMedSol(rs.getString(11));
				contato.setLaudo(rs.getString(12));
				contato.setSexo(rs.getString(13));
				contato.setEspecial(rs.getString(14));
				contato.setUrgente(rs.getString(15));
				contato.setRestaurado(rs.getString(16));

			}
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/*
	 * Editar o contato
	 */
	public void alterarContato(Paciente pessoa) {
		String update =	"UPDATE paciente SET nome=?, numAcesso=?, visita=?, patientID=?, data=?, modalidade=?, tipoExame=?, numero=?, estado=?, medSol=?, laudo=?, sexo=?, especial=?, urgente=?, restaurado=? WHERE id=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(update);

			pst.setString(1, pessoa.getNome());
			pst.setString(2, pessoa.getNumAcesso());
			pst.setString(3, pessoa.getVisita());
			pst.setString(4, pessoa.getPatientID());
			pst.setString(5, pessoa.getData());
			pst.setString(6, pessoa.getModalidade());
			pst.setString(7, pessoa.getTipoExame());
			pst.setString(8, pessoa.getNumero());
			pst.setString(9, pessoa.getEstado());
			pst.setString(10, pessoa.getMedSol());
			pst.setString(11, pessoa.getLaudo());
			pst.setString(12, pessoa.getSexo());
			pst.setString(13, pessoa.getEspecial());
			pst.setString(14, pessoa.getUrgente());
			pst.setString(15, pessoa.getRestaurado());
			
			pst.setString(16, pessoa.getId());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/*
	 * Deletar contato
	 */
	public void deletarPessoa(Paciente contato) {
		String delete = "DELETE FROM paciente WHERE id=?";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(delete);

			pst.setString(1, contato.getId());

			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public ArrayList<Login> loginAuth(Login login) {

		// Criando Objeto para acessar a classe Paciente
		ArrayList<Login> pessoa = new ArrayList<>();

		String read = "SELECT * FROM medilab.login where email=? and senha=?";

		try {
			// Abrir conexão
			Connection con = conectar();

			// Preparar a query para execução
			PreparedStatement pst = con.prepareStatement(read);
			
			pst.setString(1, login.getEmail());
			pst.setString(2, login.getSenha());

			// Armazenar temporariamente os dados obtidos pelo pst
			ResultSet rs = pst.executeQuery();

			// O laço abaixo será executado enquanto houver contatos
			while (rs.next()) {
				
				// Populando o ArrayList
				pessoa.add(new Login(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
			}
			con.close();
			return pessoa;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

}
