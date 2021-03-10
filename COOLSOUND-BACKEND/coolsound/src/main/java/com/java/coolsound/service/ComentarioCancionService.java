package com.java.coolsound.service;

import java.util.List;

import com.java.coolsound.model.ComentarioCancion;

public interface ComentarioCancionService {

	/**
	 * Gets the all ComentarioCancion.
	 *
	 * @return the all ComentarioCancion
	 */
	List<ComentarioCancion> getAllComentarioCancion(int idCancion);
	
	/**
	 * Eliminar ComentarioCancion.
	 *
	 * @return eliminar ComentarioCancion
	 */
	int eliminarComentarioCancion(int idComentarioCancion);
	
	/**
	 * Añadir ComentarioCancion.
	 *
	 * @return añadir ComentarioCancion
	 */
	int nuevoComentarioCancion(String textoComentario, int idUsuario, int idCancion);
	
}
