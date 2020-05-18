package com.estudos.financas.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.estudos.financas.services.validation.UsuarioInsert;

@UsuarioInsert
public class UsuarioNewDTO {
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Email(message="Email inválido!")
	private String email;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=8, message="Deve ser inserido no mínimo 8 caracteres!")
	private String senha;
	
	@NotEmpty(message="Preenchimento obrigatório!")
	@Length(min=2, max=100, message="Deve ser inserido entre 2 e 100 caracteres!")
	private String nome;
	
	private double orcamento;
	
	public UsuarioNewDTO() {
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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