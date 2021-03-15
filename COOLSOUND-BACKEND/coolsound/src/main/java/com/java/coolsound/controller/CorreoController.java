package com.java.coolsound.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.service.CorreoService;

@RestController
@RequestMapping(value="/email")
public class CorreoController {

	/** The CorreoService */
	@Autowired
	CorreoService cs;
	
	/**
	 * Send email.
	 *
	 */
	@GetMapping("/enviar/{asunto}/{email}/{mensaje}")
	public void enviarAgenda(@PathVariable String asunto,@PathVariable String email,@PathVariable String mensaje) {
		cs.enviarMail(asunto, email, mensaje);
	}
	
}
