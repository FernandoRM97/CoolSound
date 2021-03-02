package com.java.coolsound.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.coolsound.model.Cancion;
import com.java.coolsound.model.Hilo;

/**
 * The Interface HiloRepository.
 *
 * @author Fernando
 */
@Repository
public interface HiloRepository extends JpaRepository<Hilo, Integer> {

	/**
	 * Gets the all hilos.
	 *
	 * @return the all hilos
	 */
	@Query(value = "SELECT * FROM hilo", nativeQuery = true)
	List<Hilo> getAllHilos();

	/**
	 * Gets the one hilo.
	 *
	 * @return one hilo
	 */
	@Query(value = "DELETE FROM hilo WHERE hilo_id = ?1", nativeQuery = true)
	void borrarById(int idHilo);

}
