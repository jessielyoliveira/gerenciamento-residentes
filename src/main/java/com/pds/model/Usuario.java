package com.pds.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;

@MappedSuperclass
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "matricula")
	private String matricula;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "CPF")
	private String CPF;
	
	@Column(name = "RG")
	private String RG;
	
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	@Column(name = "datanasc")
	private Date datanasc;
	
	@Column(name = "telefone")
	private String telefone;
		
	@Column(name = "email")
	private String email;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "senha") 
	private String senha;

	public Integer getId() { return id;	}
	public void setId(Integer id) { this.id = id; }

	public String getNome() { return nome; }
	public void setNome(String nome) { this.nome = nome; }

	public String getEmail() { return email; }
	public void setEmail(String email) { this.email = email; }

	public String getUsuario() { return usuario; }
	public void setUsuario(String usuario) { this.usuario = usuario; }

	public String getSenha() { return senha; }
	public void setSenha(String senha) { this.senha = senha; }
	
	public String getMatricula() { return matricula; }
	public void setMatricula(String matricula) { this.matricula = matricula; }
	
	public String getCPF() { return CPF; }
	public void setCPF(String cPF) { CPF = cPF; }
	
	public String getRG() { return RG; }
	public void setRG(String rG) { RG = rG; }
	
	public Date getDatanasc() { return datanasc; }
	public void setDatanasc(Date datanasc) { this.datanasc = datanasc; }
	
	public String getTelefone() { return telefone; }
	public void setTelefone(String telefone) { this.telefone = telefone; }
}
