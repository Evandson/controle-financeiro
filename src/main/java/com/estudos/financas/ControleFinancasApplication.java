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
		
		Usuario usu1 = new Usuario(null, "teste1", "123", "nome1", 1234.00);
		Usuario usu2 = new Usuario(null, "teste2", "321", "nome2", 2321.00);
		usuarioRepository.saveAll(Arrays.asList(usu1, usu2));	
		
		TipoDespesa tipDesp1 = new TipoDespesa(null, "Cartão");
		TipoDespesa tipDesp2 = new TipoDespesa(null, "Internet");
		TipoDespesa tipDesp3 = new TipoDespesa(null, "Água");
		TipoDespesa tipDesp4 = new TipoDespesa(null, "Energia");
		TipoDespesa tipDesp5 = new TipoDespesa(null, "Empréstimo");
		TipoDespesa tipDesp6 = new TipoDespesa(null, "Aluguel");
		TipoDespesa tipDesp7 = new TipoDespesa(null, "Parcela Veículo");
		TipoDespesa tipDesp8 = new TipoDespesa(null, "Parcela Casa");
		TipoDespesa tipDesp9 = new TipoDespesa(null, "Gasolina");
		
		tipoDespesaRepository.saveAll(Arrays.asList(tipDesp1, tipDesp2, tipDesp3, tipDesp4, tipDesp5, 
				tipDesp6, tipDesp7, tipDesp8, tipDesp9));
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		Despesa desp1 = new Despesa(null, 80.00, "Mensalidade Internet", sdf.parse("05/04/2020"), tipDesp2, usu1);
		Despesa desp2 = new Despesa(null, 250.00, "Fatura do Cartão", sdf.parse("06/04/2020"), tipDesp1, usu1);
		despesaRepository.saveAll(Arrays.asList(desp1, desp2));
		
		tipDesp1.getDespesas().addAll(Arrays.asList(desp2));
		tipDesp2.getDespesas().addAll(Arrays.asList(desp1));
	}
}
