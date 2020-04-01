package com.estudos.financas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.estudos.financas.domain.TipoDespesa;
import com.estudos.financas.repositories.TipoDespesaRepository;

public class TipoDespesaService {
	
	@Autowired
	private TipoDespesaRepository repo;

	public TipoDespesa find(Integer id) {
		Optional<TipoDespesa> obj = repo.findById(id);
		return obj.orElse(null);
	}
	

}