package com.java.coolsound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
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
	
}
