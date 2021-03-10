package com.java.coolsound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.ComentarioCancion;
import com.java.coolsound.service.ComentarioCancionService;

@RestController
@RequestMapping(value="/comentarioCancion")
public class ComentarioCancionController {

	/** The ComentarioCancion Service*/
	@Autowired
	ComentarioCancionService ccs;
	
	/**
	 * Gets the all ComentarioCancion.
	 *
	 * @return the all ComentarioCancion
	 */
	@GetMapping("/getComentarioCancion/{idCancion}")
	public List<ComentarioCancion> getAllComentarioCancion(@PathVariable int idCancion){
		return ccs.getAllComentarioCancion(idCancion);
	}
	
	/**
	 * Borrar ComentarioCancion.
	 *
	 * @return borrar ComentarioCancion
	 */
	@GetMapping("/eliminarComentarioCancion/{idComentarioCancion}")
	public int eliminarComentarioCancion(@PathVariable int idComentarioCancion) {
		return ccs.eliminarComentarioCancion(idComentarioCancion);
	}
	
	/**
	 * Añadir ComentarioCancion.
	 *
	 * @return añadir ComentarioCancion
	 */
	@GetMapping("/nuevoComentarioCancion/{textoComentario}/{idUsuario}/{idCancion}")
	public int nuevoHilo(@PathVariable String textoComentario, @PathVariable int idUsuario, @PathVariable int idCancion) {
		return ccs.nuevoComentarioCancion(textoComentario, idUsuario, idCancion);
	}
	
}
