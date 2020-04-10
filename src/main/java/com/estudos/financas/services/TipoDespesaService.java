package com.estudos.financas.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.TipoDespesa;
import com.estudos.financas.repositories.TipoDespesaRepository;
import com.estudos.financas.services.exceptions.ObjectNotFoundException;

@Service
public class TipoDespesaService {
	
	@Autowired
	private TipoDespesaRepository repo;

	public TipoDespesa find(Integer id) {
		Optional<TipoDespesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + TipoDespesa.class.getName()));
	}

	public TipoDespesa insert(TipoDespesa obj) {
		obj.setId(null);
		return repo.save(obj);
	}
	
	public TipoDespesa update(TipoDespesa obj) {
		find(obj.getId());
		return repo.save(obj);
	}
}