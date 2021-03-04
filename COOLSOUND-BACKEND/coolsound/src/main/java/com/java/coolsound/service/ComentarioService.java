package com.java.coolsound.service;

import java.util.List;

import com.java.coolsound.model.Comentario;

public interface ComentarioService {

	/**
	 * Gets the all Comentarios.
	 *
	 * @return the all Comentarios
	 */
	List<Comentario> getAllComentarios();
	
	/**
	 * Eliminar Comentario.
	 *
	 * @return eliminar comentario
	 */
	int eliminarComentario(int idComentario);
	
	/**
	 * Añadir Comentario.
	 *
	 * @return añadir Comentario
	 */
	int nuevoComentario(int idHilo, String texto, int idUsuario);
}
