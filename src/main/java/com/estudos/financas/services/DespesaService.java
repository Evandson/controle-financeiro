package com.estudos.financas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.repositories.DespesaRepository;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository repo;

	public Despesa find(Integer id) {
		Optional<Despesa> obj = repo.findById(id);
		return obj.orElse(null);
	}
	

}
