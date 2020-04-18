package com.estudos.financas.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.repositories.DespesaRepository;
import com.estudos.financas.services.exceptions.ObjectNotFoundException;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository repo;

	public Despesa find(Integer id) {
		Optional<Despesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Despesa.class.getName()));
	}

	public Despesa insert(Despesa obj) {
		obj.setId(null);
		obj.setData(new Date());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);	
}
	}