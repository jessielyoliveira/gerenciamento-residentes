package com.pds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "solicitacoes")
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Residente solicitante;
	private Servico servico; //tipo servico solicitado
	private Date data;       //data solicitacao
	private String justificativa;
	private String materiais;
	private Status status;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Residente getSolicitante() {
		return solicitante;
	}
	public void setSolicitante(Residente solicitante) {
		this.solicitante = solicitante;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getJustificativa() {
		return justificativa;
	}
	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
	public String getMateriais() {
		return materiais;
	}
	public void setMateriais(String materiais) {
		this.materiais = materiais;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
}
