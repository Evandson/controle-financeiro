package com.estudos.financas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.estudos.financas.domain.TipoDespesa;

public class TipoDespesaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=100, message="Deve ser inserido entre 5 e 40 caracteres!")
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
