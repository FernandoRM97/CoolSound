package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Comentario;
import com.java.coolsound.model.Hilo;
import com.java.coolsound.model.Usuario;
import com.java.coolsound.repository.ComentarioRepository;
import com.java.coolsound.repository.HiloRepository;
import com.java.coolsound.repository.UserRepository;

@Service
public class ComentarioServiceImpl implements ComentarioService {

	/** The cancionesRepository. */
	@Autowired
	private ComentarioRepository comentarioRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private HiloRepository hiloRepository;

	@Override
	public List<Comentario> getAllComentarios() {
		return comentarioRepository.getAllComentarios();
	}

	/**
	 * Eliminar Comentario.
	 *
	 * @param el id del Comentario
	 */
	@Override
	public int eliminarComentario(int idComentario) {
		comentarioRepository.borrarById(idComentario);
		return idComentario;
	}
	
	/**
	 * Añadir Comentario
	 *
	 */
	@Override
	public int nuevoComentario(int idHilo, String texto, int idUsuario) {
		Comentario com = new Comentario();
		Hilo hilo = hiloRepository.getOne(idHilo);
		Usuario user = userRepository.getOne(idUsuario);
		com.setHilo(hilo);
		com.setUsuario(user);
		com.setTexto(texto);
		comentarioRepository.save(com);
		return idUsuario;
	}
}
