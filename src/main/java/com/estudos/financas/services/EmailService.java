package com.estudos.financas.services;

import org.springframework.mail.SimpleMailMessage;

import com.estudos.financas.domain.Usuario;

public interface EmailService {
	
	void sendOrderConfirmationEmail(Usuario obj);
	
	void sendEmail(SimpleMailMessage msg);
}
