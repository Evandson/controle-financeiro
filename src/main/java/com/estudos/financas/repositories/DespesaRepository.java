package com.estudos.financas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estudos.financas.domain.Despesa;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {
}