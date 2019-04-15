package com.pds.model;

public class Quartos {

	Integer piso;
	Integer numeroQuarto;
	Integer totalVagas;
	Integer vagasDisponiveis;
	
	
	
	public Quartos() {
		super();
	}

	public Quartos(Integer piso, Integer numeroQuarto, Integer totalVagas) {
		super();
		this.piso = piso;
		this.numeroQuarto = numeroQuarto;
		this.totalVagas = totalVagas;
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
