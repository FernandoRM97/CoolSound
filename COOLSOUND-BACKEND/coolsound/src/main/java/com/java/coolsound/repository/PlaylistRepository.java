package com.java.coolsound.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.coolsound.model.Playlist;

@Repository
public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {

	/**
	 * Gets the all playlists.
	 *
	 * @return the all playlists
	 */
	@Query(value = "SELECT * FROM playlists", nativeQuery = true)
	List<Playlist> getAllPlaylists();
	
	/**
	 * Gets the all playlists by IdUsuario.
	 *
	 * @return the all playlists
	 */
	@Query(value = "SELECT DISTINCT * FROM playlists WHERE usuario_id=?1", nativeQuery = true)
	List<Playlist> getAllPlaylistsById(int idUsuario);
	
	/**
	 * Borrar playlists
	 *
	 * @return playlists
	 */
    @Modifying
    @Transactional
	@Query(value = "DELETE FROM playlists WHERE playlist_id=?1", nativeQuery = true)
	void borrarById(int idPlaylist);
}
