package com.estudos.financas.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.domain.Usuario;
import com.estudos.financas.dto.DespesaDTO;
import com.estudos.financas.repositories.DespesaRepository;
import com.estudos.financas.services.DespesaService;

@RestController
@RequestMapping(value="/despesas")
public class DespesaResource {
	
	@Autowired
	private DespesaService service;
	
	@Autowired
	private DespesaRepository repo;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Despesa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
	
	/*@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<DespesaDTO>> findAll() {
		List<Despesa> list = service.findAll();
		List<DespesaDTO> listDto = list.stream().map(obj -> new DespesaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}*/
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Page<Despesa>> findPage(
			@RequestParam(value="page", defaultValue="0") Integer page, 
			@RequestParam(value="linesPerPage", defaultValue="24") Integer linesPerPage, 
			@RequestParam(value="orderBy", defaultValue="data") String orderBy, 
			@RequestParam(value="direction", defaultValue="DESC") String direction) {
		Page<Despesa> list = service.findPage(page, linesPerPage, orderBy, direction);
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Despesa obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody DespesaDTO objDto, @PathVariable Integer id) {
		Despesa obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/total", method=RequestMethod.GET)
	public Double findSum() { 
		return service.findSum();
	}
}