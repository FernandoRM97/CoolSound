package com.java.coolsound.controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.Cancion;
import com.java.coolsound.service.CancionesService;

@RestController
@RequestMapping(value = "/canciones")
public class CancionesController {

	/** The CancionesService */
	@Autowired
	CancionesService cs;

	/**
	 * Gets the all canciones.
	 *
	 * @return the all canciones
	 */
	@GetMapping("/getcanciones")
	public List<Cancion> getAllCanciones() {
		return cs.getAllCanciones();
	}

	/**
	 * 
	 * Get the songs of a user
	 * 
	 * @param idUsuario
	 * @return
	 */
	@GetMapping("/getcanciones/{idUsuario}")
	public List<Cancion> getAllCanciones(@PathVariable int idUsuario) {
		return cs.getAllCancionesById(idUsuario);
	}

	/**
	 * 
	 * Get the songs of a playlist
	 * 
	 * @param idPlaylist
	 * @return
	 */
	@GetMapping("/getCanciones/{idPlaylist}")
	public List<Cancion> getAllCancionesByIdPlaylist(@PathVariable int idPlaylist) {
		return cs.getAllCancionesByIdPlaylist(idPlaylist);
	}

	/**
	 * Eliminar cancion.
	 *
	 * @return the int
	 */
	@GetMapping("/eliminarcancion/{idCancion}")
	public int eliminarUsuario(@PathVariable int idCancion) {
		return cs.eliminarCancion(idCancion);
	}

	/**
	 * Adds the cancion.
	 *
	 * @param usuario the cancion
	 */
	@GetMapping("/nuevaCancion/{titulo}/{valoracion}/{vecesEscuchada}/{idUsu}/{genero}/**")
	public void addUsuario(HttpServletRequest request, @PathVariable String titulo, @PathVariable int valoracion,
			@PathVariable int vecesEscuchada, @PathVariable int idUsu, @PathVariable String genero) {

		String fullUrl = request.getRequestURL().toString();
		String url = fullUrl.split("/nuevaCancion/")[1];
		String[] url2 = url.split("/");

		String url3 = "";

//		for (int i = 0; i < url2.length; i++) {
//			if (i > 4 && i < (url2.length-1)) {
//				url3 = url3 + url2[i] + "/";
//			} else if ( i == (url2.length-1)) {
//				url3 = url3 + url2[i];
//			}
//			System.out.println("RESULTADO " + url3);
//		}

		for (int i = 0; i < url2.length; i++) {
			if (i == (url2.length - 1)) {
				url3 = url3 + url2[i];
			}
			System.out.println("RESULTADO " + url3);
		}
		String url4 = "https://www.youtube-nocookie.com/embed/" + url3 + "?controls=0";

		cs.addCancion(titulo, valoracion, vecesEscuchada, idUsu, genero, url4);
	}

}
