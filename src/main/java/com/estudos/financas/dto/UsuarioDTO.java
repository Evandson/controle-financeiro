package com.estudos.financas.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.estudos.financas.domain.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=100, message="Deve ser inserido entre 5 e 100 caracteres!")
	private String usuario;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=5, max=100, message="Deve ser inserido entre 5 e 100 caracteres!")
	private String nome;
	
	private double orcamento;
	
	public UsuarioDTO() {	
	}
	
	public UsuarioDTO(Usuario obj) {
		id = obj.getId();
		usuario = obj.getUsuario();
		senha = obj.getSenha();
		nome = obj.getNome();
		orcamento = obj.getOrcamento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
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
