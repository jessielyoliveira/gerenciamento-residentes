package com.pds.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "solicitacoes")
public class Solicitacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	//@NotNull 
	@JoinColumn(name = "solicitante")
	private Residente solicitante;
	
	@ManyToOne 
	@JoinColumn(name = "servico")
	private Servico servico; //tipo servico solicitado
	
	//s@OneToOne 
	//@JoinColumn(name = "avaliacao")
	//private Avaliacao avaliacao; 
	
	
	@NotNull 
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "data")
	private Date data;       //data solicitacao
	
	//@NotNull 
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "dataModificacao")
	private Date dataModificacao; 
	
	@NotNull 
	@Column(name = "justificativa")
	private String justificativa;
	
	//@NotNull 
	@Column(name = "observacao")
	private String observacao;
	
	//@NotNull 
	@Column(name = "materiais")
	private String materiais;
	
	@ManyToOne
	@JoinColumn(name = "status")
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
	public Date getDataModificacao() {
		return dataModificacao;
	}
	public void setDataModificacao(Date dataModificacao) {
		this.dataModificacao = dataModificacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
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
	
//	public Avaliacao getAvaliacao() {
//		return avaliacao;
//	}
//	public void setAvaliacao(Avaliacao avaliacao) {
//		this.avaliacao = avaliacao;
//	}
	
//	public String getMateriais() {
//		return materiais;
//	}
//	public void setMateriais(String materiais) {
//		this.materiais = materiais;
//	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
//	
//	public List<Solicitacao> getSolicitacoes() {
//		return solicitacoes; 
//	}
//	
//	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
//		this.solicitacoes = solicitacoes; 
//	}
}
