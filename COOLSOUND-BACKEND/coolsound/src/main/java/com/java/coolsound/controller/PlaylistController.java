package com.java.coolsound.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.coolsound.model.Playlist;
import com.java.coolsound.service.PlaylistService;

@RestController
@RequestMapping(value="/playlist")
public class PlaylistController {

	/** The Playlist Service*/
	@Autowired
	PlaylistService ps;
	
	/**
	 * Gets the all Playlist.
	 *
	 * @return the all Playlist
	 */
	@GetMapping("/getPlaylists")
	public List<Playlist> getAllPlaylists(){
		return ps.getAllPlaylists();
	}
	
	/**
	 * Gets the all Playlist by id cancion.
	 *
	 * @return the all Playlist
	 */
	@GetMapping("/getPlaylists/{idUsuario}")
	public List<Playlist> getAllPlaylistsById(@PathVariable int idUsuario){
		return ps.getAllPlaylistsById(idUsuario);
	}
	
	/**
	 * Añadir Playlist.
	 *
	 * @return añadir Playlist
	 */
	@GetMapping("/nuevaPlaylist/{nombrePlaylist}/{idUsuario}")
	public int nuevoHilo(@PathVariable String nombrePlaylist, @PathVariable int idUsuario) {
		return ps.nuevaPlaylist(nombrePlaylist, idUsuario);
	}
	
	/**
	 * Borrar Playlist.
	 *
	 * @return borrar Playlist
	 */
	@GetMapping("/eliminarPlaylist	/{idPlaylist}")
	public int eliminarHilo(@PathVariable int idPlaylist) {
		return ps.eliminarPlaylist(idPlaylist);
	}
	
}
