package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Usuario;
import com.java.coolsound.repository.UserRepository;

/**
 * The Class UserServiceImpl.
 *
 * @author Fernando
 */

@Service
public class UserServiceImpl implements UserService {

	/** The userRepository. */
	@Autowired
	private UserRepository userRepository;

	/**
	 * Login.
	 *
	 * @param nombre the nombre
	 * @param clave  the clave
	 * @return the usuarios
	 */
	@Override
	public Usuario login(String nombre, String clave) {
		return userRepository.login(nombre, clave);
	}

	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	@Override
	public List<Usuario> getAllUsuarios() {
		return userRepository.getAllUsuarios();
	}

	/**
	 * Adds the usuario.
	 *
	 * @param usuario the usuario
	 */
	@Override
	public void addUsuario(Usuario usuario) {
		userRepository.save(usuario);
	}

	/**
	 * Cambiar foto de perfil de Usuario
	 *
	 * @param url de la nueva imagen
	 * @param id  del Usuario
	 */
	public void changeUrl(int idUsuario, String url) {
		Usuario usuarioModificado = userRepository.getOne(idUsuario);
		usuarioModificado.setImagen(url);

		if (usuarioModificado != null) {
			userRepository.save(usuarioModificado);
		}

	}

	/**
	 * Cambiar contraseña de perfil de Usuario
	 *
	 * @param pass del Usuario
	 * @param id   del Usuario
	 */
	public void changePass(int idUsuario, String pass) {
		Usuario usuarioModificado = userRepository.getOne(idUsuario);
		usuarioModificado.setContraseña(pass);

		if (usuarioModificado != null) {
			userRepository.save(usuarioModificado);
		}

	}

	/**
	 * Eliminar usuario.
	 *
	 * @return the int
	 */
	@Override
	public int eliminarUsuario(int idUsuario) {
		userRepository.borrarById(idUsuario);
		return idUsuario;
	}

}
