package com.java.coolsound.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.NotNull;

/**
 * 
 * @author raban Clase Usuarios
 * 
 */
@Entity
@Table(name = "Usuarios")
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** Codigo del usuario */
	@Id
	@Column(name = "idUsuario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idUsuario;

	/** Nombre del usuario */
	@Column(name = "nombre", unique = true)
	@NotNull
	private String nombre;

	/** Correo del usuario */
	@Column(name = "correo", unique = true)
	@NotNull
	private String correo;

	/** Contraseña del usuario */
	@Column(name = "contraseña")
	@NotNull
	private String contraseña;

	/** Rol del usuario */
	@Column(name = "rol")
	@NotNull
	private int rol;

	/** Imagen del usuario */
	@Column(name = "imagen")
	@NotNull
	private String imagen;

//	/** Canciones del Usuario */
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//	private Set<Cancion> canciones = new HashSet<Cancion>();

//	/** Playlist del Usuario */
//	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
//	private Set<Playlist> playlists = new HashSet<Playlist>();

	/** Comentarios de Canciones del Usuario */
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<ComentarioCancion> comentarioCanciones = new HashSet<ComentarioCancion>();

	/** Hilos del Usuario */
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Hilo> hilos = new HashSet<Hilo>();

	/** Comentarios del Usuario en el Hilo del Foro */
	@OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
	private Set<Comentario> comentarios = new HashSet<Comentario>();

	/** Getter del Codigo del Usuario */
	public int getIdUsuario() {
		return idUsuario;
	}

	/** Setter del Codigo del Usuario */
	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	/** Getter del Nombre del Usuario */
	public String getNombre() {
		return nombre;
	}

	/** Setter del Nombre del Usuario */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** Getter del Correo del Usuario */
	public String getCorreo() {
		return correo;
	}

	/** Setter del Correo del Usuario */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/** Getter de la Contraseña del Usuario */
	public String getContraseña() {
		return contraseña;
	}

	/** Setter de la Contraseña del Usuario */
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}

	/** Getter del Rol del Usuario */
	public int getRol() {
		return rol;
	}

	/** Setter del Rol del Usuario */
	public void setRol(int rol) {
		this.rol = rol;
	}

	/** Getter de la Imagen del Usuario */
	public String getImagen() {
		return imagen;
	}

	/** Setter de la Imagen del Usuario */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

//	/** Getter de la Cancion del Usuario */
//	public Set<Cancion> getCanciones() {
//		return canciones;
//	}
//
//	/** Set de la Cancion del Usuario */
//	public void setCanciones(Set<Cancion> canciones) {
//		this.canciones = canciones;
//	}

//	/** Getter de las Playlists */
//	public Set<Playlist> getPlaylists() {
//		return playlists;
//	}
//
//	/** Setter de las Playlists */
//	public void setPlaylists(Set<Playlist> playlists) {
//		this.playlists = playlists;
//	}

	/** Getter de los Comentarios de las Canciones */
	public Set<ComentarioCancion> getComentarioCanciones() {
		return comentarioCanciones;
	}

	/** Setter de los Comentarios de las Canciones */
	public void setComentarioCanciones(Set<ComentarioCancion> comentarioCanciones) {
		this.comentarioCanciones = comentarioCanciones;
	}

	/** Getter de los Hilos */
	public Set<Hilo> getHilos() {
		return hilos;
	}

	/** Setter de los Hilos */
	public void setHilos(Set<Hilo> hilos) {
		this.hilos = hilos;
	}

	/** Getter de los Hilos */
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	/** Setter de los Hilos */
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/** Constructor de la clase Usuario */
	public Usuario(int idUsuario, String nombre, String correo, String contraseña, int rol, String imagen,
			Set<Cancion> canciones, Set<Playlist> playlists, Set<ComentarioCancion> comentarioCanciones,
			Set<Hilo> hilos, Set<Comentario> comentarios) {
		super();
		this.idUsuario = idUsuario;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.rol = rol;
		this.imagen = imagen;
//		this.canciones = canciones;
//		this.playlists = playlists;
		this.comentarioCanciones = comentarioCanciones;
		this.hilos = hilos;
		this.comentarios = comentarios;
	}

	public Usuario() {
		super();
	}

	/** ToString de la clase Usuario */
	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombre=" + nombre + ", correo=" + correo + ", contraseña="
				+ contraseña + ", rol=" + rol + ", imagen=" + imagen + ", canciones=" + "canciones" + ", playlists="
				+ "playlists" + ", comentarioCanciones=" + comentarioCanciones + ", hilos=" + hilos + ", comentarios="
				+ comentarios + "]";
	}

	/** Hash Code de la clase Usuario */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result + ((canciones == null) ? 0 : canciones.hashCode());
		result = prime * result + ((comentarioCanciones == null) ? 0 : comentarioCanciones.hashCode());
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + ((contraseña == null) ? 0 : contraseña.hashCode());
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((hilos == null) ? 0 : hilos.hashCode());
		result = prime * result + idUsuario;
		result = prime * result + ((imagen == null) ? 0 : imagen.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
//		result = prime * result + ((playlists == null) ? 0 : playlists.hashCode());
		result = prime * result + rol;
		return result;
	}

	/** Equals de la clase Usuario */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
//		if (canciones == null) {
//			if (other.canciones != null)
//				return false;
//		} else if (!canciones.equals(other.canciones))
//			return false;
		if (comentarioCanciones == null) {
			if (other.comentarioCanciones != null)
				return false;
		} else if (!comentarioCanciones.equals(other.comentarioCanciones))
			return false;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (contraseña == null) {
			if (other.contraseña != null)
				return false;
		} else if (!contraseña.equals(other.contraseña))
			return false;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (hilos == null) {
			if (other.hilos != null)
				return false;
		} else if (!hilos.equals(other.hilos))
			return false;
		if (idUsuario != other.idUsuario)
			return false;
		if (imagen == null) {
			if (other.imagen != null)
				return false;
		} else if (!imagen.equals(other.imagen))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
//		if (playlists == null) {
//			if (other.playlists != null)
//				return false;
//		} else if (!playlists.equals(other.playlists))
//			return false;
		if (rol != other.rol)
			return false;
		return true;
	}

}
