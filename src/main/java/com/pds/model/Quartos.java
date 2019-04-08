package com.pds.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Quartos implements Serializable {

	private static final long serialVersionUID = 1L;

	Residencia residencia;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer idResidencia;
	private Integer piso;
	private Integer quarto;
	private Integer vagasDisponiveis;

	@ManyToOne
	@JoinColumn(name = "quartos")
	private Residencia quartos;

	public Quartos(Integer idResidencia, Integer piso, Integer quarto, Integer vagasDisponiveis) {
		super();
		this.idResidencia = residencia.getId();
		this.piso = residencia.getQuantPisos();
		this.quarto = residencia.getQuantQuartosPorPiso();
		this.vagasDisponiveis = residencia.getQuantResidentesPorQuarto();
	}

	public Integer getPiso() {
		return piso;
	}

	public void setPiso(Integer piso) {
		this.piso = piso;
	}

	public Integer getQuarto() {
		return quarto;
	}

	public void setQuarto(Integer quarto) {
		this.quarto = quarto;
	}

	public Integer getVagasDisponiveis() {
		return vagasDisponiveis;
	}

	public void setVagasDisponiveis(Integer vagasDisponiveis) {
		this.vagasDisponiveis = vagasDisponiveis;
	}

	public Integer getIdResidencia() {
		return idResidencia;
	}

	public void setIdResidencia(Integer idResidencia) {
		this.idResidencia = idResidencia;
	}

}
