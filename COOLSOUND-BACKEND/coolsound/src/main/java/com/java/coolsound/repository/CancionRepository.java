package com.java.coolsound.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.coolsound.model.Cancion;

/**
 * The Interface CancionRepository.
 *
 * @author Fernando
 */
@Repository
public interface CancionRepository extends JpaRepository<Cancion, Integer>{

	/**
	 * Gets the all canciones.
	 *
	 * @return the all canciones
	 */
	@Query(value = "SELECT * FROM canciones", nativeQuery = true)
	List<Cancion> getAllCanciones();
	
	/**
	 * Gets the all canciones by id.
	 *
	 * @return the all canciones
	 */
	@Query(value = "SELECT * FROM canciones WHERE usuario_id= ?1", nativeQuery = true)
	List<Cancion> getAllCancionesById(int idUsuario);
	
	/**
	 * Gets the all canciones by idPlaylist.
	 *
	 * @return the all canciones
	 */
	@Query(value = "SELECT * FROM canciones WHERE playlist_id= ?1", nativeQuery = true)
	List<Cancion> getAllCancionesByIdPlaylist(int idPlaylist);
	
	/**
	 * Gets the cancion
	 *
	 * @return the cancion
	 */
	@Query(value = "SELECT * FROM canciones WHERE cancion_id= ?1", nativeQuery = true)
	List<Cancion> getCancion(int idCancion);
	
	/**
	 * Borrar Cancion
	 *
	 * @return idCancion
	 */
    @Modifying
    @Transactional
	@Query(value = "DELETE FROM canciones WHERE cancion_id=?1", nativeQuery = true)
	void borrarById(int idCancion);
	
}
