package com.estudos.financas;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.estudos.financas.domain.Usuario;
import com.estudos.financas.repositories.UsuarioRepository;

@SpringBootApplication
public class ControleFinancasApplication implements CommandLineRunner {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ControleFinancasApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Usuario usu1 = new Usuario(null, "teste", "123", "admin", 1234.00);
		
		usuarioRepository.saveAll(Arrays.asList(usu1));
		
	}

}
