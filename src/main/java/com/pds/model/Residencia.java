package com.pds.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "residencias")
public class Residencia implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotEmpty
	@Column(name = "nome")
	private String nome;

	@NotEmpty
	@Column(name = "endereco")
	private String endereco;

	@NotEmpty
	@Column(name = "numero")
	private String numero;

	@NotEmpty
	@Column(name = "bairro")
	private String bairro;

	@NotEmpty
	@Column(name = "cep")
	private String cep;

	@NotEmpty
	@Column(name = "cidade")
	private String cidade;

	@NotEmpty
	@Column(name = "estado")
	private String estado;

	@NotNull
	@Column(name = "quantPisos")
	private Integer quantPisos;

	@NotNull
	@Column(name = "quantQuartosPorPiso")
	private Integer quantQuartosPorPiso;

	@NotNull
	@Column(name = "quantResidentesPorQuarto")
	private Integer quantResidentesPorQuarto;

	@NotNull
	@Column(name = "TotalVagas")
	private Integer totalVagas = 0;

	@OneToMany(mappedBy = "residencia", cascade = CascadeType.ALL)
	List<Residente> residentes;
	
	Quartos quartos[][] = new Quartos[1][1];

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getQuantPisos() {
		return quantPisos;
	}

	public void setQuantPisos(Integer quantPisos) {
		this.quantPisos = quantPisos;
	}

	public Integer getQuantQuartosPorPiso() {
		return quantQuartosPorPiso;
	}

	public void setQuantQuartosPorPiso(Integer quantQuartosPorPiso) {
		this.quantQuartosPorPiso = quantQuartosPorPiso;
	}

	public Integer getQuantResidentesPorQuarto() {
		return quantResidentesPorQuarto;
	}

	public void setQuantResidentesPorQuarto(Integer quantResidentesPorQuarto) {
		this.quantResidentesPorQuarto = quantResidentesPorQuarto;
	}

	public Integer getTotalVagas() {
		return quantPisos * quantQuartosPorPiso * quantResidentesPorQuarto;
	}

	public List<Residente> getResidentes() {
		return residentes;
	}

	public void setResidentes(List<Residente> residentes) {
		this.residentes = residentes;
	}
	

	public Quartos[][] getQuartos() {
		return quartos;
	}

	public void setQuartos(Quartos[][] quartos) {
		this.quartos = quartos;
	}
	
	public void setMatrizQuartos() {
		this.quartos = new Quartos[quantPisos][quantQuartosPorPiso];
	}

}
