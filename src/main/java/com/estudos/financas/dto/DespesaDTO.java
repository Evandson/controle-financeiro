package com.estudos.financas.dto;

import java.io.Serializable;
import java.util.Date;

import com.estudos.financas.domain.Despesa;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DespesaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double valor;
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	public DespesaDTO() {	
	}
	
	public DespesaDTO(Despesa obj) {
		id = obj.getId();
		valor = obj.getValor();
		descricao = obj.getDescricao();
		data = obj.getData();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
