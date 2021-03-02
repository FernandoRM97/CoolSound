package com.java.coolsound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.Hilo;
import com.java.coolsound.service.HiloService;

@RestController
@RequestMapping(value="/hilo")
public class HiloController {

	/** The Hilo Service*/
	@Autowired
	HiloService hs;
	
	/**
	 * Gets the all canciones.
	 *
	 * @return the all canciones
	 */
	@GetMapping("/getHilos")
	public List<Hilo> getAllHilos(){
		return hs.getAllHilos();
	}
	
	/**
	 * Borrar Hilo.
	 *
	 * @return borrar hilo
	 */
	@GetMapping("/eliminarHilo/{idHilo}")
	public void eliminarHilo(@PathVariable int idHilo) {
	}
	
	
	
}
