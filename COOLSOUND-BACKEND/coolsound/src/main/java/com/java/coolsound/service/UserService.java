package com.java.coolsound.service;

import java.util.List;

import com.java.coolsound.model.Usuario;

/**
 * The Interface UserService.
 *
 * @author Fernando
 */
public interface UserService {
	
	/**
	 * Login.
	 *
	 * @param nombre the nombre
	 * @param clave the clave
	 * @return the usuarios
	 */
	Usuario login(String nombre, String clave);
	
	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	List<Usuario> getAllUsuarios();
	
	/**
	 * Adds the usuario.
	 *
	 * @param usuario the usuario
	 */
	void addUsuario(Usuario usuario);
	
	
	/**
	 * Modificar usuario.
	 *
	 * @param user the user
	 */
	
	void modificarUsuario(Usuario user);
	
	/**
	 * Eliminar usuario.
	 *
	 * @param codusu the codusu
	 * @return the int
	 */
	int eliminarUsuario(int codusu);
	
	/**
	 * Cambiar foto perfil del usuario
	 * 
	 * @param url nueva imagen
	 * @param id del Usuario	
	 */
	void changeUrl(int idUsuario, String url);
	
	/**
	 * Cambiar foto perfil del usuario
	 * 
	 * @param url nueva imagen
	 * @param id del Usuario	
	 */
	void changePass(int idUsuario, String pass);
}