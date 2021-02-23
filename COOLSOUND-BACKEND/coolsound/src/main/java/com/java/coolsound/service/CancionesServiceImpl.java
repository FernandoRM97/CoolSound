package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Cancion;
import com.java.coolsound.repository.CancionRepository;

@Service
public class CancionesServiceImpl implements CancionesService{

	/** The cancionesRepository. */
	@Autowired
	private CancionRepository cancionRepository;

	@Override
	public List<Cancion> getAllCanciones() {
		return cancionRepository.getAllCanciones();
	}

	@Override
	public List<Cancion> getAllCancionesById(int idUsuario) {
		return cancionRepository.getAllCancionesById(idUsuario);
	}
	

}
