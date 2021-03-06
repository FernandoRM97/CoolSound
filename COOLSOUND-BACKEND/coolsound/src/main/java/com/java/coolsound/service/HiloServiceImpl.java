package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Comentario;
import com.java.coolsound.model.Hilo;
import com.java.coolsound.model.Usuario;
import com.java.coolsound.repository.HiloRepository;
import com.java.coolsound.repository.UserRepository;

@Service
public class HiloServiceImpl implements HiloService {

	/** The cancionesRepository. */
	@Autowired
	private HiloRepository hiloRepository;
	
	/** The UserRepository. */
	@Autowired
	private UserRepository userRepository;

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
	 * Eliminar Hilo.
	 *
	 * @param el id del Hilo
	 */
	@Override
	public int eliminarHilo(int idHilo) {
		hiloRepository.borrarById(idHilo);
		return idHilo;
	}
	
	/**
	 * Añadir Hilo
	 *
	 * @param nombre del Hilo
	 * @param el id del Usuario
	 */
	@Override
	public int nuevoHilo(String nombreHilo, int idUsuario) {
		Hilo hilo = new Hilo();
		hilo.setNombre(nombreHilo);
		Usuario user = userRepository.getOne(idUsuario);
		hilo.setUsuario(user);
		hiloRepository.save(hilo);
		return idUsuario;
	}

	public List<Comentario> getHilos(int idHilo) {
		return hiloRepository.getHilos(idHilo);
	}
}
