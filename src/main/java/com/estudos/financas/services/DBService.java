package com.estudos.financas.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.Despesa;
import com.estudos.financas.domain.TipoDespesa;
import com.estudos.financas.domain.Usuario;
import com.estudos.financas.domain.enums.Perfil;
import com.estudos.financas.repositories.DespesaRepository;
import com.estudos.financas.repositories.TipoDespesaRepository;
import com.estudos.financas.repositories.UsuarioRepository;

@Service
public class DBService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private TipoDespesaRepository tipoDespesaRepository;
	
	@Autowired
	private DespesaRepository despesaRepository;
	
	@Autowired
	private BCryptPasswordEncoder enc;
	
	public void instantiateTestDatabase() throws ParseException {
		
		Usuario usu1 = new Usuario(null, "teste1@email.com", enc.encode("123"), "nome1", 1234.00);
		Usuario usu2 = new Usuario(null, "teste2@email.com", enc.encode("321"), "nome2", 2321.00);
		Usuario usu3 = new Usuario(null, "teste3@email.com", enc.encode("098"), "nome3", 2321.00);
		usu3.addPerfil(Perfil.ADMIN);
		usuarioRepository.saveAll(Arrays.asList(usu1, usu2, usu3));	
		
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
		Despesa desp3 = new Despesa(null, 130.00, "Fatura do Cartão", sdf.parse("07/04/2020"), tipDesp1, usu2);
		Despesa desp4 = new Despesa(null, 150.00, "Conta de Energia", sdf.parse("07/04/2020"), tipDesp4, usu2);
		despesaRepository.saveAll(Arrays.asList(desp1, desp2, desp3, desp4));
		
		tipDesp1.getDespesas().addAll(Arrays.asList(desp2));
		tipDesp2.getDespesas().addAll(Arrays.asList(desp1));
		
	}
}