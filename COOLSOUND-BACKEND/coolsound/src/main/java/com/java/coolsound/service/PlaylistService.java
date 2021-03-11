package com.java.coolsound.service;

import java.util.List;

import com.java.coolsound.model.Playlist;

public interface PlaylistService {

	/**
	 * Gets the all Playlists.
	 *
	 * @return the all playlists
	 */
	List<Playlist> getAllPlaylists();
	
	/**
	 * Gets the all Playlists by IdCancion.
	 *
	 * @return the all playlists
	 */
	List<Playlist> getAllPlaylistsById(int idUsuario);
	
	/**
	 * Añadir Playlists.
	 *
	 * @return añadir Playlists
	 */
	int nuevaPlaylist(String nombrePlaylist, int idUsuario);
	
	/**
	 * Eliminar Playlists.
	 *
	 * @return eliminar Playlists
	 */
	int eliminarPlaylist(int idPlaylist);
	
}
