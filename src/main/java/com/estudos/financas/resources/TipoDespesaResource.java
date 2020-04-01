package com.estudos.financas.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.estudos.financas.domain.TipoDespesa;
import com.estudos.financas.services.TipoDespesaService;

@RestController
@RequestMapping(value="/tipoDespesas")
public class TipoDespesaResource {
	
	@Autowired
	private TipoDespesaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		TipoDespesa obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}