/**
 * 
 */
package com.java.coolsound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.Usuario;
import com.java.coolsound.service.UserService;

/**
 * The Class UsuariosController.
 *
 * @author fernando
 */
@RestController
@RequestMapping(value="/usuarios")
public class UsuariosController {
	
	/** The UserService */
	@Autowired
	UserService us;
	
	/**
	 * Login.
	 *
	 * @param nombre the nombre
	 * @param clave the clave
	 * @return the usuarios
	 */
	@GetMapping("/login/{nombre}/{contraseña}")
	public Usuario login(@PathVariable String nombre, @PathVariable String contraseña) {
		return us.login(nombre, contraseña);
	}
	
	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	@GetMapping("/getusuarios")
	public List<Usuario> getAllUsuarios(){
		return us.getAllUsuarios();
	}
	
	/**
	 * Adds the usuario.
	 *
	 * @param usuario the usuario
	 */
	@PostMapping("/addusuario")
	public void addUsuario(@RequestBody Usuario usuario) {
		us.addUsuario(usuario);
	}
	
	/**
	 * Modificar usuario.
	 *
	 * @param user the user
	 */
	@PutMapping("/modificarusuario")
	public void modificarUsuario(@RequestBody Usuario user) {
		us.modificarUsuario(user);
	}
	
	/**
	 * Eliminar usuario.
	 *
	 * @param codusu the codusu
	 * @return the int
	 */
	@DeleteMapping("/eliminarusuario/{codusu}")
	public int eliminarUsuario(@PathVariable int codusu) {
		return us.eliminarUsuario(codusu);
	}
	
}