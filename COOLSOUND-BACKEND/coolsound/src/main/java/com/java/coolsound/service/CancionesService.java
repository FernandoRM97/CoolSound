package com.java.coolsound.service;

import java.util.List;

import com.java.coolsound.model.Cancion;

public interface CancionesService {

	/**
	 * Gets the all canciones.
	 *
	 * @return the all canciones
	 */
	List<Cancion> getAllCanciones();
	
}
