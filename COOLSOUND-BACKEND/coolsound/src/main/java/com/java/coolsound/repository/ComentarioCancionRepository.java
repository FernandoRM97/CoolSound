package com.java.coolsound.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.coolsound.model.ComentarioCancion;

/**
 * The Interface ComentarioCancionRepository.
 *
 * @author Fernando
 */
@Repository
public interface ComentarioCancionRepository extends JpaRepository<ComentarioCancion, Integer>{

	/**
	 * Gets the comentarios.
	 *
	 * @return the all comentarios
	 */
    @Query(value = "SELECT * FROM comentario_canciones WHERE cancion_id=?1", nativeQuery = true)
    List<ComentarioCancion> getAllComentarioCancion(int idCancion);
    
	/**
	 * Gets the one hilo.
	 * @return 
	 *
	 * @return one hilo
	 */
    @Modifying
    @Transactional
	@Query(value = "DELETE FROM comentario_canciones WHERE comentariocancion_id=?1", nativeQuery = true)
	void borrarById(int idComentarioCancion);
    
}
