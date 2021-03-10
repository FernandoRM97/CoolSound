package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Cancion;
import com.java.coolsound.model.Usuario;
import com.java.coolsound.repository.CancionRepository;
import com.java.coolsound.repository.UserRepository;

@Service
public class CancionesServiceImpl implements CancionesService {

	/** The cancionesRepository. */
	@Autowired
	private CancionRepository cancionRepository;

	/** The UserRepository. */
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<Cancion> getAllCanciones() {
		return cancionRepository.getAllCanciones();
	}

	@Override
	public List<Cancion> getAllCancionesById(int idUsuario) {
		return cancionRepository.getAllCancionesById(idUsuario);
	}
	
	@Override
	public List<Cancion> getCancion(int idCancion) {
		return cancionRepository.getCancion(idCancion);
	}
	
	@Override
	public List<Cancion> getAllCancionesByIdPlaylist(int idPlaylist) {
		return cancionRepository.getAllCancionesByIdPlaylist(idPlaylist);
	}

	/**
	 * Eliminar cancion.
	 *
	 * @return the int
	 */
	@Override
	public int eliminarCancion(int idCancion) {
		cancionRepository.borrarById(idCancion);
		return idCancion;
	}

	/**
	 * Adds the usuario.
	 *
	 * @param usuario the usuario
	 */
	@Override
	public void addCancion(String titulo , int valoracion, int vecesEscuchada, int idUsu,
		String genero, String cancion) {
		Cancion canc = new Cancion();
		Usuario user = userRepository.getOne(idUsu);
		
		canc.setGenero(genero);
		canc.setMusica(cancion);
		canc.setTitulo(titulo);
		canc.setUsuario(user);
		canc.setValoracion(valoracion);
		canc.setVecesEscuchada(vecesEscuchada);
		String portada = "https://images-na.ssl-images-amazon.com/images/I/51NqbdDrbOL.png";
		canc.setPortada(portada);
		
		cancionRepository.save(canc);
		
	}
	
	/**
	 * Cambiar foto de perfil de Usuario
	 *
	 * @param url de la nueva imagen
	 * @param id  del Usuario
	 */
	public void changeUrl(int idCancion, String url) {
		Cancion cancionModificada = cancionRepository.getOne(idCancion);
		cancionModificada.setPortada(url);

		if (cancionModificada != null) {
			cancionRepository.save(cancionModificada);
		}

	}

}
