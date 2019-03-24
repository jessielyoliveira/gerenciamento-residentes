package com.pds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "residentes")
public class Residente extends Usuario implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "curso")
	private String curso;	

	@Column(name = "estadoOrigem")
	private String estadoOrigem;
	
	@Column(name = "cidadeOrigem")
	private String cidadeOrigem;

	@Column(name = "bolsaPROAE")
	private String bolsaPROAE;
	
	@JoinColumn(name = "residencia")
	private Residencia residencia;
	
	@Column(name = "campus")
	private Integer campus;
	
	@Column(name = "piso")
	private Integer piso;
	
	@Column(name =  "quarto")
	private Integer quarto;
		
	@Column(name =  "dataTermino")
	private Date dataTermino;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Residencia getResidencia() {
		return residencia;
	}
	
	public void setResidencia(Residencia residencia) {
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

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getCidadeOrigem() {
		return cidadeOrigem;
	}

	public void setCidadeOrigem(String cidade) {
		this.cidadeOrigem = cidade;
	}

	public String getEstadoOrigem() {
		return estadoOrigem;
	}

	public void setEstadoOrigem(String estado) {
		this.estadoOrigem = estado;
	}
}
