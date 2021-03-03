package com.java.coolsound.service;

import java.util.List;

import com.java.coolsound.model.Hilo;

public interface HiloService {

	/**
	 * Gets the all hilos.
	 *
	 * @return the all hilos
	 */
	List<Hilo> getAllHilos();
	
	/**
	 * Eliminar Hilo.
	 *
	 * @return eliminar hilo
	 */
	int eliminarHilo(int idHilo);
	
	/**
	 * Añadir Hilo.
	 *
	 * @return añadir hilo
	 */
	int nuevoHilo(String nombreHilo, int idUsuario);
}
