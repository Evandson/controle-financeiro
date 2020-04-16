package com.estudos.financas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.TipoDespesa;
import com.estudos.financas.dto.TipoDespesaDTO;
import com.estudos.financas.repositories.TipoDespesaRepository;
import com.estudos.financas.services.exceptions.DataIntegrityException;
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
		TipoDespesa newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(obj);
	}
	
	private void updateData(TipoDespesa newObj, TipoDespesa obj) {
		newObj.setTipo(obj.getTipo());
	}

	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir! O tipo de despesa é associado a despesa(s) de usuário(s)");
		}
	}

	public List<TipoDespesa> findAll() {
		return repo.findAll();
	}
	
	public TipoDespesa fromDTO(TipoDespesaDTO objDto) {
		return new TipoDespesa(objDto.getId(), objDto.getTipo());
	}	
}