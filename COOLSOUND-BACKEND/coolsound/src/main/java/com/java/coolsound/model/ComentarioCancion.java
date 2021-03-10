package com.java.coolsound.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * 
 * @author raban Clase ComentarioCanciones
 * 
 */
@Entity
@Table(name = "ComentarioCanciones")
public class ComentarioCancion {

	/** Codigo del ComentarioCancion */
	@Id
	@Column(name = "COMENTARIOCANCION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComentarioCancion;
	
	/** Nombre de la Playlist */
	@Column(name = "NOMBRE", unique = true)
	@NotNull
	private String nombre;
	
	/** Usuario */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	/** Cancion */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "CANCION_ID")
	private Cancion cancion;

	/** Getter del Id del Comentario de la Cancion */
	public int getIdComentarioCancion() {
		return idComentarioCancion;
	}

	/** Setter del Id del Comentario de la Cancion */
	public void setIdComentarioCancion(int idComentarioCancion) {
		this.idComentarioCancion = idComentarioCancion;
	}

	/** Getter del Nombre del Comentario de la Cancion */
	public String getNombre() {
		return nombre;
	}

	/** Setter del Nombre del Comentario de la Cancion */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** Getter del Usuario del Comentario de la Cancion */
	public Usuario getUsuario() {
		return usuario;
	}

	/** Setter del Usuario del Comentario de la Cancion */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/** Getter de la Cancion del Comentario */
	public Cancion getCancion() {
		return cancion;
	}

	/** Setter de la Cancion del Comentario */
	public void setCancion(Cancion cancion) {
		this.cancion = cancion;
	}

	/** Constructor de la clase ComentarioCancion */
	public ComentarioCancion(int idComentarioCancion, String nombre, Usuario usuario, Cancion cancion) {
		super();
		this.idComentarioCancion = idComentarioCancion;
		this.nombre = nombre;
		this.usuario = usuario;
		this.cancion = cancion;
	}

	
	/** Constructor por defecto de la clase ComentarioCancion */
	public ComentarioCancion() {
		super();
	}

	/** ToString de la clase ComentarioCancion */
	@Override
	public String toString() {
		return "ComentarioCancion [idComentarioCancion=" + idComentarioCancion + ", nombre=" + nombre + ", usuario="
				+ usuario + ", cancion=" + cancion + "]";
	}

	/** HashCode de la clase ComentarioCancion */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cancion == null) ? 0 : cancion.hashCode());
		result = prime * result + idComentarioCancion;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/** Equals de la clase ComentarioCancion */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ComentarioCancion other = (ComentarioCancion) obj;
		if (cancion == null) {
			if (other.cancion != null)
				return false;
		} else if (!cancion.equals(other.cancion))
			return false;
		if (idComentarioCancion != other.idComentarioCancion)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
	
}
