package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Hilo;
import com.java.coolsound.repository.HiloRepository;

@Service
public class HiloServiceImpl implements HiloService {

	/** The cancionesRepository. */
	@Autowired
	private HiloRepository hiloRepository;

	/**
	 * Get all Hilos
	 * 
	 * @return all hilos
	 */
	@Override
	public List<Hilo> getAllHilos() {
		return hiloRepository.getAllHilos();
	}
	
	/**
	 * Eliminar usuario.
	 *
	 * @param codusu the codusu
	 * @return the int
	 */
	@Override
	public void eliminarHilo(int idHilo) {
		System.out.println(idHilo);
		hiloRepository.borrarById(idHilo);
	}

}
