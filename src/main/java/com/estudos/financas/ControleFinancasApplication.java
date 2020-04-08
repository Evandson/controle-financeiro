package com.estudos.financas;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.domain.TipoDespesa;
import com.estudos.financas.domain.Usuario;
import com.estudos.financas.repositories.DespesaRepository;
import com.estudos.financas.repositories.TipoDespesaRepository;
import com.estudos.financas.repositories.UsuarioRepository;

@SpringBootApplication
public class ControleFinancasApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoDespesaRepository tipoDespesaRepository;
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleFinancasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Usuario usu1 = new Usuario(null, "teste", "123", "admin", 1234.00);
		usuarioRepository.saveAll(Arrays.asList(usu1));	
		
		TipoDespesa tipDesp1 = new TipoDespesa(null, "Cartão");
		TipoDespesa tipDesp2 = new TipoDespesa(null, "Internet");
		tipoDespesaRepository.saveAll(Arrays.asList(tipDesp1, tipDesp2));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Despesa desp1 = new Despesa(null, 80.00, "Mensalidade Internet", sdf.parse("05/04/2020"), tipDesp2, usu1);
		Despesa desp2 = new Despesa(null, 250.00, "Fatura do Cartão", sdf.parse("06/04/2020"), tipDesp1, usu1);
		despesaRepository.saveAll(Arrays.asList(desp1, desp2));
		
		tipDesp1.getDespesas().addAll(Arrays.asList(desp2));
		tipDesp2.getDespesas().addAll(Arrays.asList(desp1));
	}
}
