package com.pds.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avaliacoes")
public class Avaliacao implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@JoinColumn(name = "solicitacao")
	private Solicitacao solicitacao;
	
	@Column(name = "grauSatisfacaoSolicitacao")
	private Integer grauSatisfacaoSolicitacao;
	
	@Column(name = "comentarioSolicitacao")
	private String comentarioSolicitacao;
	
	@Column(name = "notaFuncionario")
	private Integer notaFuncionario;
	
	@Column(name = "comentarioFuncionario")
	private String comentarioFuncionario;
	
	@OneToOne(mappedBy="avaliacao", cascade = CascadeType.ALL)
    //List<Solicitacao> solicitacoes;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


//	public List<Solicitacao> getSolicitacoes() {
//		return solicitacoes; 
//	}
//	
//	public void setSolicitacoes(List<Solicitacao> solicitacoes) {
//		this.solicitacoes = solicitacoes;
//	}

	public Integer getGrauSatisfacaoSolicitacao() {
		return grauSatisfacaoSolicitacao;
	}

	public void setGrauSatisfacaoSolicitacao(Integer grauSatisfacaoSolicitacao) {
		this.grauSatisfacaoSolicitacao = grauSatisfacaoSolicitacao;
	}

	public String getComentarioSolicitacao() {
		return comentarioSolicitacao;
	}

	public void setComentarioSolicitacao(String comentarioSolicitacao) {
		this.comentarioSolicitacao = comentarioSolicitacao;
	}

	public Integer getNotaFuncionario() {
		return notaFuncionario;
	}

	public void setNotaFuncionario(Integer notaFuncionario) {
		this.notaFuncionario = notaFuncionario;
	}

	public String getComentarioFuncionario() {
		return comentarioFuncionario;
	}

	public void setComentarioFuncionario(String comentarioFuncionario) {
		this.comentarioFuncionario = comentarioFuncionario;
	}

	
}
