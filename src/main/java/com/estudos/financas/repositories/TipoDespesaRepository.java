package com.estudos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.financas.domain.TipoDespesa;


@Repository
	public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Integer>{
		
	}