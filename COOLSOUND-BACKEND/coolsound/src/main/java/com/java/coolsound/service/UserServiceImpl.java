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
	 * @param clave the clave
	 * @return the usuarios
	 */
	@Override
	public Usuario login(String nombre, String clave) {
		System.out.println(userRepository.login(nombre, clave));
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


//	/**
//	 * Modificar usuario.
//	 *
//	 * @param user the user
//	 */
	@Override
	public void modificarUsuario(Usuario user) {
//		
//		Usuario updateUser = userRepository.findOne(user.getIdUsuario());
//		
//		if(updateUser != null) {
//			
//			updateUser.setNombre(user.getNombre());
//			updateUser.setCorreo(user.getCorreo());
//			updateUser.setContraseña(user.getContraseña());
//			updateUser.setRol(user.getRol());
//			userRepository.save(updateUser);
//		}
//		
	}

//	/**
//	 * Eliminar usuario.
//	 *
//	 * @param codusu the codusu
//	 * @return the int
//	 * //
	@Override
	public int eliminarUsuario(int codusu) {
//		Usuario deleteUser = userRepository.findOne(codusu);
//		
//		if(deleteUser != null) {
//			try {
//				userRepository.delete(deleteUser);
//				return 1;
//			} catch (Exception e) {
//				return 0;
//			}
//		}
		return 0;
	}
	
}
