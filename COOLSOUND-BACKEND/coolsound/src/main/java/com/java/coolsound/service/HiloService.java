package com.java.coolsound.service;

import java.util.List;

import com.java.coolsound.model.Comentario;
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
	
	/**
	 * Gets a hilo.
	 *
	 * @return the hilo
	 */
	List<Comentario> getHilos(int idHilo);
}
