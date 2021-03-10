package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Cancion;
import com.java.coolsound.model.ComentarioCancion;
import com.java.coolsound.model.Usuario;
import com.java.coolsound.repository.CancionRepository;
import com.java.coolsound.repository.ComentarioCancionRepository;
import com.java.coolsound.repository.UserRepository;

@Service
public class ComentarioCancionServiceImpl implements ComentarioCancionService{

	/** The comentarioCancionesRepository. */
	@Autowired
	private ComentarioCancionRepository comentarioCancionRepository;
	
	/** The UserRepository. */
	@Autowired
	private UserRepository userRepository;
	
	/** The cancionesRepository. */
	@Autowired
	private CancionRepository cancionRepository;

	@Override
	public List<ComentarioCancion> getAllComentarioCancion(int idCancion) {
		return comentarioCancionRepository.getAllComentarioCancion(idCancion);
	}

	@Override
	public int eliminarComentarioCancion(int idComentarioCancion) {
		comentarioCancionRepository.borrarById(idComentarioCancion);
		return idComentarioCancion;
	}

	@Override
	public int nuevoComentarioCancion(String textoComentario, int idUsuario, int idCancion) {
		
		ComentarioCancion cc = new ComentarioCancion();
		Usuario user = userRepository.getOne(idUsuario);
		Cancion cancion = cancionRepository.getOne(idCancion);
		cc.setCancion(cancion);
		cc.setNombre(textoComentario);
		cc.setUsuario(user);
		
		comentarioCancionRepository.save(cc);
		
		return idCancion;
	}
	
}
