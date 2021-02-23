package com.java.coolsound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.Cancion;
import com.java.coolsound.service.CancionesService;

@RestController
@RequestMapping(value="/canciones")
public class CancionesController {

	/** The CancionesService */
	@Autowired
	CancionesService cs;
	
	/**
	 * Gets the all canciones.
	 *
	 * @return the all canciones
	 */
	@GetMapping("/getcanciones")
	public List<Cancion> getAllCanciones(){
		return cs.getAllCanciones();
	}
	
	@GetMapping("/getcanciones/{idUsuario}")
	public List<Cancion> getAllCanciones(@PathVariable int idUsuario){
		return cs.getAllCancionesById(idUsuario);
	}
	
}
