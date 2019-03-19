package com.pds.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "residencias")
public class Residencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "endereco")
	private String endereco;
	
	@Column(name = "numero")
	private Integer numero;
	
	@Column(name = "bairro")
	private String bairro;
	
	@Column(name = "cep")
	private String cep;
	
	@Column(name = "cidade")
	private String cidade;
	
	@Column(name = "estado")
	private String uf;
	
	@Column(name = "quant_pisos")
	private Integer quantPisos;
	
	@Column(name = "quant_quartos")
	private Integer quantQuartosPorPiso;
	
	@Column(name = "quant_residentes")
	private Integer quantResidentesPorQuarto;
	
	public Integer getId() { return id; }
	public void setId(Integer id) { this.id = id; }
	
	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }
	
	public String getEndereco() { return endereco; }
	public void setEndereco(String endereco) { this.endereco = endereco; }
	
	public String getBairro() { return bairro; }
	public void setBairro(String bairro) { this.bairro = bairro; }
	
	public String getCep() { return cep; }
	public void setCep(String cep) { this.cep = cep; }
	
	public String getCidade() { return cidade; }
	public void setCidade(String cidade) { this.cidade = cidade; }
	
	public String getEstado() { return uf; }
	public void setEstado(String estado) { this.uf = estado; }
	
	public Integer getNumero() { return numero; }
	public void setNumero(Integer numero) { this.numero = numero; }
	
	public Integer getQuantPisos() { return quantPisos; }
	public void setQuantPisos(Integer quantPisos) { this.quantPisos = quantPisos; }
	
	public Integer getQuantQuartos() { return quantQuartosPorPiso; }
	public void setQuantQuartos(Integer quantQuartos) { this.quantQuartosPorPiso = quantQuartos; }
	
	public Integer getQuantResidentes() { return quantResidentesPorQuarto; }
	public void setQuantResidentes(Integer quantResidentes) { this.quantResidentesPorQuarto = quantResidentes; }
	
	
}
