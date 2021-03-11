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
	 * Gets the cancion
	 *
	 * @return the cancion
	 */
	List<Cancion> getCancion(int idCancion);
	
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
	
	/**
	 * Cambiar foto de la portada
	 * 
	 * @param url nueva imagen
	 * @param id de la cancion	
	 */
	void changeUrl(int idCancion, String url);
	
	/**
	 * Cambiar la valoracion de una cancion
	 * @param valoracion
	 * @param vecesValorada
	 * @param idCancion
	 */
	void changeValoracion(int valoracion, int vecesValorada, int idCancion);
	
	/**
	 * Cambiar la playlist de una cancion
	 * @param idCancion
	 * @param idPlaylist
	 */
	void changePlaylist(int idCancion, int idPlaylist);
	
	/**
	 * Veces Escuchada +1
	 * @param idCancion
	 */
	void vecesEscuchada(int idCancion);
	
	/**
	 * Canciones Mas Escuchadas
	 * @return 
	 */
	List<Cancion> masEscuchadas();
	
	/**
	 * Canciones Mejor Valoradas
	 * @return 
	 */
	List<Cancion> mejorValoradas();
}

