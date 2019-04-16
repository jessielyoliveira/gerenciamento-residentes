package com.pds.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quartos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	String id;
	
	private Integer idResidencia;
	private Integer piso;
	private Integer numeroQuarto;
	private Integer totalVagas;
	private Integer vagasDisponiveis;
	
	@ManyToOne
	@JoinColumn(name = "residencia")
	private Residencia residencia;
	
	public Quartos() {
		super();
	}

	public Quartos(Integer idResidencia, Integer piso, Integer numeroQuarto, Integer totalVagas) {
		super();
		this.id = idResidencia.toString() + piso.toString() + numeroQuarto.toString();
		this.piso = piso;
		this.numeroQuarto = numeroQuarto;
		this.totalVagas = totalVagas;
	}
	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getIdResidencia() {
		return idResidencia;
	}

	public void setIdResidencia(Integer idResidencia) {
		this.idResidencia = idResidencia;
	}

	public Integer getPiso() {
		return piso;
	}
	
	public void setPiso(Integer piso) {
		this.piso = piso;
	}
	
	public Integer getNumeroQuarto() {
		return numeroQuarto;
	}
	
	public void setNumeroQuarto(Integer numeroQuarto) {
		this.numeroQuarto = numeroQuarto;
	}
	
	public Integer getTotalVagas() {
		return totalVagas;
	}
	
	public void setTotalVagas(Integer totalVagas) {
		this.totalVagas = totalVagas;
	}
	
	public Integer getVagasDisponiveis() {
		return vagasDisponiveis;
	}
	
	public void setVagasDisponiveis(Integer vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}
	
}
