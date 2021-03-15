package com.java.coolsound.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping(value = "/usuarios")
public class UsuariosController {

	/** The UserService */
	@Autowired
	UserService us;

	/**
	 * Login.
	 *
	 * @param nombre the nombre
	 * @param clave  the clave
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
	public List<Usuario> getAllUsuarios() {
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
	 * Cambiar foto perfil usuario
	 * 
	 * @param url imagen
	 * @param id  usuario
	 */
	@GetMapping("/changeUrl/{idUsuario}/**")
	public void changeUrl(HttpServletRequest request, @PathVariable int idUsuario) {
		String fullUrl = request.getRequestURL().toString();
		String url = fullUrl.split("/changeUrl/")[1];
		url = url.replace(idUsuario + "/", "");
//	    System.out.println(url.toString());
//	    System.out.println(idUsuario);
		us.changeUrl(idUsuario, url);
	}

	/**
	 * Cambiar contraseña perfil usuario
	 * 
	 * @param url imagen
	 * @param id  usuario
	 */
	@GetMapping("/changePass/{idUsuario}/{pass}")
	public void changePass(@PathVariable int idUsuario, @PathVariable String pass) {
		us.changePass(idUsuario, pass);
	}

	/**
	 * Borrar Hilo.
	 *
	 * @return borrar hilo
	 */
	@GetMapping("/eliminarUsuario/{idUsuario}")
	public int eliminarHilo(@PathVariable int idUsuario) {
		return us.eliminarUsuario(idUsuario);
	}
}