package com.estudos.financas.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.estudos.financas.domain.Usuario;
import com.estudos.financas.services.validation.UsuarioUpdate;

@UsuarioUpdate
public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="Email inválido!")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=2, max=100, message="Deve ser inserido entre 2 e 100 caracteres!")
	private String nome;
	
	private double orcamento;
	
	public UsuarioDTO() {	
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		email = obj.getEmail();
		nome = obj.getNome();
		orcamento = obj.getOrcamento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(double orcamento) {
		this.orcamento = orcamento;
	}
}