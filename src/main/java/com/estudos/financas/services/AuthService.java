package com.estudos.financas.services;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.estudos.financas.domain.Usuario;
import com.estudos.financas.repositories.UsuarioRepository;
import com.estudos.financas.services.exceptions.ObjectNotFoundException;

@Service
public class AuthService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private EmailService emailService;

	private Random rand = new Random();

	public void sendNewPassword(String email) {

		Usuario usuario = usuarioRepository.findByEmail(email);
		if (usuario == null) {
			throw new ObjectNotFoundException("Email n�o encontrado");
		}

		String newPass = newPassword();
		usuario.setSenha(pe.encode(newPass));

		usuarioRepository.save(usuario);
		emailService.sendNewPasswordEmail(usuario, newPass);
	}

	private String newPassword() {
		char[] vet = new char[10];
		for (int i=0; i<10; i++) {
			vet[i] = randomChar();
		}
		return new String(vet);
	}

	private char randomChar() {
		int opt = rand.nextInt(3);
		if (opt == 0) { 
			return (char) (rand.nextInt(10) + 48);
		}
		else if (opt == 1) {
			return (char) (rand.nextInt(26) + 65);
		}
		else { 
			return (char) (rand.nextInt(26) + 97);
		}
	}
}