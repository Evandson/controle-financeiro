package com.estudos.financas.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.domain.Usuario;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {
	
	@Transactional(readOnly=true)
	Page<Despesa> findByUsuario(Usuario usuario, Pageable pageRequest);
}