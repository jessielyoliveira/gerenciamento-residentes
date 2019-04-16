package com.pds.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pds.exception.BusinessException;
import com.pds.exception.ModelException;
import com.pds.model.Quartos;
import com.pds.model.Residencia;
import com.pds.repository.ResidenciaRepository;

@Service
@Transactional(readOnly = true)
public class ResidenciaService {

	@Autowired
	private ResidenciaRepository residenciaRepository;

	@Transactional(readOnly = false)
	public Residencia save(Residencia residencia) {
		residenciaRepository.save(residencia);
		inicializaQuartos(residencia);	
		return residenciaRepository.save(residencia);
	}

	public List<Residencia> findAll() {
		return residenciaRepository.findAll();
	}

	public Optional<Residencia> findOne(Integer id) {
		return residenciaRepository.findById(id);
	}

	@Transactional(readOnly = false)
	public void delete(Residencia residencia) {
		residenciaRepository.delete(residencia);
	}

	public void validar(Residencia residencia) throws BusinessException {
		if (residencia.getQuantPisos() < 1 || residencia.getQuantPisos() > 10) {
			throw new BusinessException("Quantidade de pisos invalida");
		}
		if (residencia.getQuantQuartosPorPiso() < 1 || residencia.getQuantQuartosPorPiso() > 15) {
			throw new BusinessException("Quantidade de quartos por pisos invalida");
		}
		if (residencia.getQuantResidentesPorQuarto() < 1 || residencia.getQuantResidentesPorQuarto() > 8) {
			throw new BusinessException("Quantidade de residentes por quarto invalida");
		}
	}

	public void existe(Residencia residencia) throws ModelException {
		List<Residencia> residencias = findAll();
		for (Residencia r : residencias) {
			String nome = r.getNome().toLowerCase();
			String numero = r.getNumero().toLowerCase();
			if (nome.equals(residencia.getNome().toLowerCase())) {
				throw new ModelException("Nome ja cadastrado");
			}
			if (numero.equals(residencia.getNumero().toLowerCase())) {
				throw new ModelException("Numero ja cadastrado");
			}
		}
	}

	public List<Residencia> search(String chave) {
		return residenciaRepository.buscaPorNome(chave);
	}
	
	public void inicializaQuartos(Residencia residencia) {
		for(Integer i = 0; i < residencia.getQuantPisos(); i++) {
			for(Integer j = 0; j < residencia.getQuantQuartosPorPiso(); j++) {
				Quartos quarto = new Quartos(residencia.getId(), i, j, residencia.getTotalVagas());
				residencia.adicionarQuarto(quarto);
				System.out.println("ID QUARTO = " + quarto.getId());
			}
		}
	}
	
	public void imprimeMatriz(Residencia residencia) {
		if(residencia.getQuartos() == null) {
			System.out.println("QUARTOS NULOS ");
		} else {
			List<Quartos> lista = residencia.getQuartos();
			System.out.println("RESIDENCIA = " + lista);
			System.out.println("residencia.getQuartos().size() = " + residencia.getQuartos().size());
			for (int i = 0; i < residencia.getQuartos().size(); i++) {
				System.out.println(residencia.getQuartos().get(i));
			}
		}
		
	}
	
	/*
	 * public void declaraMatrizQuartos(Residencia residencia) { Quartos[][] matriz
	 * = new
	 * Quartos[residencia.getQuantPisos()][residencia.getQuantQuartosPorPiso()];
	 * residencia.setQuartos(matriz); }
	 * 
	 * public void inicializMatrizQuartos(Residencia residencia) { Quartos[][]
	 * matriz = residencia.getQuartos(); for(Integer i = 0; i <
	 * residencia.getQuantPisos(); i++) { for(Integer j = 0; j <
	 * residencia.getQuantQuartosPorPiso(); j++) { matriz[i][j] = new Quartos();
	 * matriz[i][j].setPiso(i); matriz[i][j].setNumeroQuarto(j);
	 * matriz[i][j].setTotalVagas(residencia.getTotalVagas()); } }
	 * residencia.setQuartos(matriz); }
	 * 
	 * public void imprimeMatriz(Residencia residencia) { Quartos[][] matriz =
	 * residencia.getQuartos(); for(Integer i = 0; i < residencia.getQuantPisos();
	 * i++) { for (int j = 0; j < residencia.getQuantQuartosPorPiso(); j++) {
	 * System.out.println("[ " + matriz[i][j].getPiso() + ", " +
	 * matriz[i][j].getNumeroQuarto() + ", " + matriz[i][j].getTotalVagas() + " ]");
	 * } } }
	 */

}
