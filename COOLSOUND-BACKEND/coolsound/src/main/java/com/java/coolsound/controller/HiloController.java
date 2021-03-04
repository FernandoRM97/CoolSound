package com.java.coolsound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.Comentario;
import com.java.coolsound.model.Hilo;
import com.java.coolsound.service.HiloService;

@RestController
@RequestMapping(value="/hilo")
public class HiloController {

	/** The Hilo Service*/
	@Autowired
	HiloService hs;
	
	/**
	 * Gets the all Hilos.
	 *
	 * @return the all Hilos
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
	public int eliminarHilo(@PathVariable int idHilo) {
		return hs.eliminarHilo(idHilo);
	}
	
	/**
	 * Añadir Hilo.
	 *
	 * @return añadir hilo
	 */
	@GetMapping("/nuevoHilo/{nombreHilo}/{idUsuario}")
	public int nuevoHilo(@PathVariable String nombreHilo, @PathVariable int idUsuario) {
		return hs.nuevoHilo(nombreHilo, idUsuario);
	}
	
	/**
	 * Gets a Hilo.
	 *
	 * @return the Hilo.
	 */
	@GetMapping("/hilos/{idHilo}")
	public List<Comentario> getAllHilos(@PathVariable int idHilo){
		return hs.getHilos(idHilo);
	}
	
	
}
