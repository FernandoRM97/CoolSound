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

	/**
	 * Gets the all canciones by id.
	 *
	 * @return the all canciones
	 */
	List<Cancion> getAllCancionesById(int idUsuario);

	/**
	 * Gets the all canciones by idPlaylist.
	 *
	 * @return the all canciones bt idPlaylist
	 */
	List<Cancion> getAllCancionesByIdPlaylist(int idPlaylist);
	
	/**
	 * Eliminar cancion.
	 *
	 * @return the int
	 */
	int eliminarCancion(int idCancion);

	/**
	 * Adds the cancion.
	 *
	 * @param usuario the cancion
	 */
	void addCancion(String titulo, int valoracion, int vecesEscuchada, int idUsu ,
			String genero, String cancion);
}
