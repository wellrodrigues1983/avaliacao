/**
 * 
 */
package br.com.lab.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

/**
 * @author Wellington
 *
 */

public class Paciente {

	private String id;
	private String nome;
	private String numAcesso;
	private String visita;
	private String patientID;
	private String data;
	private String modalidade;
	private String tipoExame;
	private String numero;
	private String estado;
	private String medSol;
	private String laudo;
	private String sexo;
	private String especial;
	private String urgente;
	private String restaurado;

	/**
	 * 
	 */
	public Paciente() {
		// TODO Auto-generated constructor stub
	}

	public Paciente(String id, String nome, String numAcesso, String visita, String patientID, String data, String modalidade, String tipoExame,
			String numero, String estado, String medSol, String laudo, String sexo, String especial, String urgente, String restaurado) {
		super();
		this.id = id;
		this.nome = nome;
		this.numAcesso = numAcesso;
		this.visita = visita;
		this.patientID = patientID;
		this.data = data;
		this.modalidade = modalidade;
		this.tipoExame = tipoExame;
		this.numero = numero;
		this.estado = estado;
		this.medSol = medSol;
		this.laudo = laudo;
		this.sexo = sexo;
		this.especial = especial;
		this.urgente = urgente;
		this.restaurado = restaurado;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNumAcesso() {
		return numAcesso;
	}

	public void setNumAcesso(String numAcesso) {
		this.numAcesso = numAcesso;
	}

	public String getVisita() {
		return visita;
	}

	public void setVisita(String visita) {
		this.visita = visita;
	}

	public String getPatientID() {
		return patientID;
	}

	public void setPatientID(String patientID) {
		this.patientID = patientID;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getTipoExame() {
		return tipoExame;
	}

	public void setTipoExame(String tipoExame) {
		this.tipoExame = tipoExame;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getMedSol() {
		return medSol;
	}

	public void setMedSol(String medSol) {
		this.medSol = medSol;
	}

	public String getLaudo() {
		return laudo;
	}

	public void setLaudo(String laudo) {
		this.laudo = laudo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEspecial() {
		return especial;
	}

	public void setEspecial(String especial) {
		this.especial = especial;
	}

	public String getUrgente() {
		return urgente;
	}

	public void setUrgente(String urgente) {
		this.urgente = urgente;
	}

	public String getRestaurado() {
		return restaurado;
	}

	public void setRestaurado(String restaurado) {
		this.restaurado = restaurado;
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
		Paciente other = (Paciente) obj;
		return Objects.equals(id, other.id);
	}

	
}
