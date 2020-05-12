package com.estudos.financas.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.domain.Usuario;
import com.estudos.financas.dto.DespesaDTO;
import com.estudos.financas.repositories.DespesaRepository;
import com.estudos.financas.security.UserSS;
import com.estudos.financas.services.exceptions.AuthorizationException;
import com.estudos.financas.services.exceptions.ObjectNotFoundException;

@Service
public class DespesaService {
	
	@Autowired
	private DespesaRepository repo;
	
	@Autowired
	private UsuarioService usuarioService;

	public Despesa find(Integer id) {
		Optional<Despesa> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Despesa.class.getName()));
	}
	
	public List<Despesa> findAll() {
		return repo.findAll();
	}

	public Despesa insert(Despesa obj) {
		obj.setId(null);
		obj.setData(new Date());
		return repo.save(obj);
	}
	
	public Despesa update(Despesa obj) {
		Despesa newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
		
	}
	
	private void updateData(Despesa newObj, Despesa obj) {
		newObj.setValor(obj.getValor());
		newObj.setDescricao(obj.getDescricao());
		newObj.setTipoDespesa(obj.getTipoDespesa());
	}

	public void delete(Integer id) {
		find(id);
		repo.deleteById(id);	
}

	public Despesa fromDTO(DespesaDTO objDto) {
		Despesa des = new Despesa (null, objDto.getValor(), objDto.getDescricao(), null, objDto.getTipoDespesa(), null);
		return des; 
	}
	
	public Page<Despesa> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Usuario usuario =  usuarioService.find(user.getId());
		return repo.findByUsuario(usuario, pageRequest);
	}
	
	public Double findSum() {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		Usuario usuario =  usuarioService.find(user.getId());
		return repo.somaDespesas(usuario);
}
	}