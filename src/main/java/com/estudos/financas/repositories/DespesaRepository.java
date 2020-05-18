package com.estudos.financas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.domain.Usuario;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Integer> {
	
	@Transactional(readOnly=true)
	List<Despesa> findByUsuario(Usuario usuario);
	
	@Query("SELECT SUM(m.valor) FROM Despesa m WHERE m.usuario = ?1")
	Double somaDespesas(Usuario usuario);
}