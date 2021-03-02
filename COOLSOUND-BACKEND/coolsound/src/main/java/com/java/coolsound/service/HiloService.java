package com.java.coolsound.service;

import java.util.List;

import org.springframework.stereotype.Service;

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
	void eliminarHilo(int idHilo);
}
