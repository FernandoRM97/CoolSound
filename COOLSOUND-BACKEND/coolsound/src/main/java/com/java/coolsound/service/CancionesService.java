package com.java.coolsound.service;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.java.coolsound.model.Cancion;

public interface CancionesService {

	/**
	 * Gets the all canciones.
	 *
	 * @return the all canciones
	 */
	List<Cancion> getAllCanciones();
	
	/**
	 * Gets the all canciones by id.
	 *
	 * @return the all canciones
	 */
	List<Cancion> getAllCancionesById(int idUsuario);
	
}
