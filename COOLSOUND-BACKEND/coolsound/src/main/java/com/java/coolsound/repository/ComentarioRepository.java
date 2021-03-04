package com.java.coolsound.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.coolsound.model.Comentario;

@Repository
public interface ComentarioRepository extends JpaRepository<Comentario, Integer> {

	/**
	 * Gets the all comentarios.
	 *
	 * @return the all comentarios
	 */
	@Query(value = "SELECT * FROM comentario", nativeQuery = true)
	List<Comentario> getAllComentarios();
	
	/**
	 * Gets the one Comentario.
	 * @return 
	 *
	 * @return one Comentario
	 */
    @Modifying
    @Transactional
	@Query(value = "DELETE FROM comentario WHERE comentario_id=?1", nativeQuery = true)
	void borrarById(int idComentario);

}
