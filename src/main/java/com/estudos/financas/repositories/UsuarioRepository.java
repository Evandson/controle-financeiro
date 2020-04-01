package com.estudos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.financas.domain.Usuario;


@Repository
	public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{
		
	}