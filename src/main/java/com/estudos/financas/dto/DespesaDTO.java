package com.estudos.financas.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.domain.TipoDespesa;
import com.fasterxml.jackson.annotation.JsonFormat;

public class DespesaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private double valor;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=100, message="Deve ser inserido entre 5 e 100 caracteres!")
	private String descricao;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	private Date data;
	
	private TipoDespesa tipoDespesa;
	
	public DespesaDTO() {	
	}
	
	public DespesaDTO(Despesa obj) {
		id = obj.getId();
		valor = obj.getValor();
		descricao = obj.getDescricao();
		data = obj.getData();
		tipoDespesa = obj.getTipoDespesa();
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

	public TipoDespesa getTipoDespesa() {
		return tipoDespesa;
	}

	public void setTipoDespesa(TipoDespesa tipoDespesa) {
		this.tipoDespesa = tipoDespesa;
	}
}