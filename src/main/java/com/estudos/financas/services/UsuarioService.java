package com.estudos.financas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.Usuario;
import com.estudos.financas.dto.UsuarioDTO;
import com.estudos.financas.dto.UsuarioNewDTO;
import com.estudos.financas.repositories.UsuarioRepository;
import com.estudos.financas.services.exceptions.DataIntegrityException;
import com.estudos.financas.services.exceptions.ObjectNotFoundException;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repo;
	
	@Autowired
	private BCryptPasswordEncoder enc;

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
		Usuario newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Usuario newObj, Usuario obj) {
		newObj.setEmail(obj.getEmail());
		newObj.setNome(obj.getNome());
		newObj.setOrcamento(obj.getOrcamento());
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
	
	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(objDto.getId(), objDto.getEmail(), null, objDto.getNome(), objDto.getOrcamento());
	}
	
	public Usuario fromDTO(UsuarioNewDTO objDto) {
		Usuario usu = new Usuario (null, objDto.getEmail(), enc.encode(objDto.getSenha()), objDto.getNome(), objDto.getOrcamento());
		return usu;
	}
	
	public Page<Usuario> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
}