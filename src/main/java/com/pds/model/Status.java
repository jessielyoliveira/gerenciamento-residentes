package com.pds.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "status")
public class Status {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Date modificacao;
	private String observacao; 
	
		
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Date getModificacao() {
		return modificacao;
	}
	public void setModificacao(Date modificacao) {
		this.modificacao = modificacao;
	}
	public String getObservacao() {
		return observacao;
	}
	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
	
	@ManyToMany(mappedBy="status", cascade = CascadeType.ALL)
    List<Solicitacao> solicitacoes;
	
	public List<Solicitacao> getSolicitacoes() { 
		return solicitacoes; 
	}
	
	public void setSolicitacoes(List<Solicitacao> solicitacoes) { 
		this.solicitacoes = solicitacoes;	
	}
	
}
	