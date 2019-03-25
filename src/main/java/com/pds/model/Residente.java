package com.pds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Residente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String residencia; //ALTERAR PARA TIPO RESIDENCIA QUANDO TIVER A CLASSE CONSTRUIDA
	private Integer campus;
	private Integer piso;
	private Integer quarto;
	private String bolsaPROAE;
	private Date dataTermino;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getResidencia() {
		return residencia;
	}
	
	public void setResidencia(String residencia) {
		this.residencia = residencia;
	}
	
	public Integer getCampus() {
		return campus;
	}
	
	public void setCampus(Integer campus) {
		this.campus = campus;
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
	
	public String getBolsaPROAE() {
		return bolsaPROAE;
	}
	
	public void setBolsaPROAE(String bolsaPROAE) {
		this.bolsaPROAE = bolsaPROAE;
	}
	
	public Date getDataTermino() {
		return dataTermino;
	}
	
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
}
