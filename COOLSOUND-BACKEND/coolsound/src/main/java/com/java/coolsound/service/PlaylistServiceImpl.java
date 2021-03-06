package com.java.coolsound.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.coolsound.model.Hilo;
import com.java.coolsound.model.Playlist;
import com.java.coolsound.model.Usuario;
import com.java.coolsound.repository.PlaylistRepository;
import com.java.coolsound.repository.UserRepository;

@Service
public class PlaylistServiceImpl implements PlaylistService {

	/** The PlaylistRepository */
	@Autowired
	private PlaylistRepository playlistRepository;
	
	/** The UserRepository. */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Sacar las Playlists de BD
	 */
	@Override
	public List<Playlist> getAllPlaylists() {
		return playlistRepository.getAllPlaylists();
	}
	
	/**
	 * Añadir HPlaylistsilo
	 *
	 * @param nombre del Playlists
	 * @param el id del Usuario
	 */
	@Override
	public int nuevaPlaylist(String nombrePlaylist, int idUsuario) {
		Playlist playlist = new Playlist();
		playlist.setNombre(nombrePlaylist);
		Usuario user = userRepository.getOne(idUsuario);
		playlist.setUsuario(user);
		playlistRepository.save(playlist);
		return idUsuario;
	}
	
	/**
	 * Eliminar Playlist.
	 *
	 * @param el id del Hilo
	 */
	@Override
	public int eliminarPlaylist(int idPlaylist) {
		playlistRepository.borrarById(idPlaylist);
		return idPlaylist;
	}

}
