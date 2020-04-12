package com.estudos.financas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.Usuario;
import com.estudos.financas.repositories.UsuarioRepository;
import com.estudos.financas.services.exceptions.DataIntegrityException;
import com.estudos.financas.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;

	public Usuario find(Integer id) {
		Optional<Usuario> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Usuario.class.getName()));
	}
	
	public Usuario insert(Usuario obj) {
		obj.setId(null);
		return repo.save(obj);
	}

	public Usuario update(Usuario obj) {
		find(obj.getId());
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		find(id);
		try {
			repo.deleteById(id);	
		}catch (DataIntegrityViolationException e) {
			throw new DataIntegrityException("Não é possível excluir! O usuário é associado a despesas");
		}
		
	}

	public List<Usuario> findAll() {
		return repo.findAll();
	}
}