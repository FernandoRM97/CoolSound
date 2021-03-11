package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Cancion;
import com.java.coolsound.model.Playlist;
import com.java.coolsound.model.Usuario;
import com.java.coolsound.repository.CancionRepository;
import com.java.coolsound.repository.PlaylistRepository;
import com.java.coolsound.repository.UserRepository;

@Service
public class CancionesServiceImpl implements CancionesService {

	/** The cancionesRepository. */
	@Autowired
	private CancionRepository cancionRepository;

	/** The UserRepository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The playlistRepository */
	@Autowired
	private PlaylistRepository playlistRepository;

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
		String portada = "https://i1.wp.com/www.wisum.mx/blog/wp-content/uploads/2019/11/Mu%CC%81sica_portada.jpg?fit=1500%2C844&ssl=1";
		canc.setPortada(portada);
		canc.setVecesValorada(0);
		
		cancionRepository.save(canc);
		
	}
	
	/**
	 * Cambiar portada Cancion
	 * @param url de la nueva imagen
	 * @param id  de la Cancion
	 */
	public void changeUrl(int idCancion, String url) {
		Cancion cancionModificada = cancionRepository.getOne(idCancion);
		cancionModificada.setPortada(url);

		if (cancionModificada != null) {
			cancionRepository.save(cancionModificada);
		}

	}

	/**
	 * Metodo para cambiar la valoracion de una cancion
	 */
	@Override
	public void changeValoracion(int valoracion, int vecesValorada, int idCancion) {
		Cancion cancionModificada = cancionRepository.getOne(idCancion);
		cancionModificada.setValoracion(valoracion);
		cancionModificada.setVecesValorada(vecesValorada);

		if (cancionModificada != null) {
			cancionRepository.save(cancionModificada);
		}
		
	}
	
	/**
	 * Metodo para cambiar la playlist de una cancion
	 */
	@Override
	public void changePlaylist(int idCancion, int idPlaylist) {
		Cancion cancionModificada = cancionRepository.getOne(idCancion);
		Playlist playlistModificada = playlistRepository.getOne(idPlaylist);
		cancionModificada.setPlaylist(playlistModificada);

		if (cancionModificada != null) {
			cancionRepository.save(cancionModificada);
		}
		
	}

	
	/** Método para añadir +1 a Veces Escuchada */
	@Override
	public void vecesEscuchada(int idCancion) {
		Cancion cancionModificada = cancionRepository.getOne(idCancion);
		int vecesEscuchada = (int) cancionModificada.getVecesEscuchada();
		vecesEscuchada = vecesEscuchada+1;
		cancionModificada.setVecesEscuchada(vecesEscuchada);
		
		if (cancionModificada != null) {
			cancionRepository.save(cancionModificada);
		}
	}

	/** Método para sacar las canciones mas escuchadas de BD */
	@Override
	public List<Cancion> masEscuchadas() {
		return cancionRepository.masEscuchadas();	
	}
	
	/** Método para sacar las canciones mas escuchadas de BD */
	@Override
	public List<Cancion> mejorValoradas() {
		return cancionRepository.mejorValoradas();
	}
	
	

}
