package com.java.coolsound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.Comentario;
import com.java.coolsound.service.ComentarioService;

@RestController
@RequestMapping(value="/comentarios")
public class ComentarioController {

	/** The Comentario Service*/
	@Autowired
	ComentarioService cs;
	
	/**
	 * Gets the all Comentarios.
	 *
	 * @return the all Comentarios
	 */
	@GetMapping("/getComentarios")
	public List<Comentario> getAllComentarios(){
		return cs.getAllComentarios();
	}
	
	/**
	 * Borrar Hilo.
	 *
	 * @return borrar hilo
	 */
	@GetMapping("/eliminarComentario/{idComentario}")
	public int eliminarHilo(@PathVariable int idComentario) {
		return cs.eliminarComentario(idComentario);
	}
	
	/**
	 * Añadir Comentario.
	 *
	 * @return añadir comentario
	 */
	@GetMapping("/nuevoComentario/{idHilo}/{texto}/{idUsuario}")
	public int nuevoHilo(@PathVariable int idHilo,@PathVariable String texto, @PathVariable int idUsuario) {
		return cs.nuevoComentario(idHilo, texto, idUsuario);
	}
}
