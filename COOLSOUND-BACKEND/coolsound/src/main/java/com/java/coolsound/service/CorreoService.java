package com.java.coolsound.service;

public interface CorreoService {

	/** 
	 * Método para enviar un correo desde Sobre Nosotros
	 */
	public void enviarMail(String asunto, String email, String mensaje);
	
}
