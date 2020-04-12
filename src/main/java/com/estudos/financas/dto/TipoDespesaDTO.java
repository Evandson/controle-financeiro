package com.estudos.financas.dto;

import java.io.Serializable;

import com.estudos.financas.domain.TipoDespesa;

public class TipoDespesaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String tipo;
	
	public TipoDespesaDTO () {
	}
	
	public TipoDespesaDTO (TipoDespesa obj) {
		id = obj.getId();
		tipo = obj.getTipo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
