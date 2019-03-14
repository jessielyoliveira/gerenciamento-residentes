package com.pds.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Residencia implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String nome;
	private String endereco;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private Integer numero;
	private Integer quantPisos;
	private Integer quantQuartos;
	private Integer quantResidentes;
	
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
	
	public String getEstado() { return estado; }
	public void setEstado(String estado) { this.estado = estado; }
	
	public Integer getNumero() { return numero; }
	public void setNumero(Integer numero) { this.numero = numero; }
	
	public Integer getQuantPisos() { return quantPisos; }
	public void setQuantPisos(Integer quantPisos) { this.quantPisos = quantPisos; }
	
	public Integer getQuantQuartos() { return quantQuartos; }
	public void setQuantQuartos(Integer quantQuartos) { this.quantQuartos = quantQuartos; }
	
	public Integer getQuantResidentes() { return quantResidentes; }
	public void setQuantResidentes(Integer quantResidentes) { this.quantResidentes = quantResidentes; }
	
	
}
