package com.java.coolsound.repository;

/**
 * 
 */


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.coolsound.model.Usuario;



/**
 * The Interface UserRepository.
 *
 * @author Fernando
 */
@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer>{
	
	/**
	 * Login.
	 *
	 * @param nombre the nombre
	 * @param clave the clave
	 * @return the usuarios
	 */
	@Query(value = "SELECT * FROM usuarios WHERE nombre like ?1 and contraseña like ?2", nativeQuery = true)
	Usuario login(String nombre, String contraseña);
	
	/**
	 * Gets the all usuarios.
	 *
	 * @return the all usuarios
	 */
	@Query(value = "SELECT * FROM usuarios", nativeQuery = true)
	List<Usuario> getAllUsuarios();
	
}
