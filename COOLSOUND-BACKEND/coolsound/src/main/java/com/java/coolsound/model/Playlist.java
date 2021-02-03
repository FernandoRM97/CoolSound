package com.java.coolsound.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.sun.istack.NotNull;

/**
 * 
 * @author raban Clase Playlist
 * 
 */
@Entity
@Table(name = "Playlists")
public class Playlist {

	/** Codigo de la Playlist */
	@Id
	@Column(name = "PLAYLIST_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPlaylist;
	
	/** Nombre de la Playlist */
	@Column(name = "NOMBRE", unique = true)
	@NotNull
	private String nombre;
	
	/** Usuario */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	/** Canciones de la Playlist */
	@OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
	private Set<Cancion> canciones = new HashSet<Cancion>();

	/** Getter de la Id de la Playlist */
	public int getIdPlaylist() {
		return idPlaylist;
	}

	/** Set de la Id de la Playlist */
	public void setIdPlaylist(int idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	/** Getter del Nombre de la Playlist */
	public String getNombre() {
		return nombre;
	}

	/** Set del Nombre de la Playlist */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** Getter del Usuario de la Playlist */
	public Usuario getUsuario() {
		return usuario;
	}

	/** Set del Usuario de la Playlist */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/** Getter de las Canciones de la Playlist */
	public Set<Cancion> getCanciones() {
		return canciones;
	}

	/** Set de las Canciones de la Playlist */
	public void setCanciones(Set<Cancion> canciones) {
		this.canciones = canciones;
	}

	/** Constructor de la clase Playlist */
	public Playlist(int idPlaylist, String nombre, Usuario usuario, Set<Cancion> canciones) {
		super();
		this.idPlaylist = idPlaylist;
		this.nombre = nombre;
		this.usuario = usuario;
		this.canciones = canciones;
	}

	/** ToString de la clase Playlist */
	@Override
	public String toString() {
		return "Playlist [idPlaylist=" + idPlaylist + ", nombre=" + nombre + ", usuario=" + usuario + ", canciones="
				+ canciones + "]";
	}

	/** HashCode de la clase Playlist */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((canciones == null) ? 0 : canciones.hashCode());
		result = prime * result + idPlaylist;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/** Equals de la clase Playlist */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Playlist other = (Playlist) obj;
		if (canciones == null) {
			if (other.canciones != null)
				return false;
		} else if (!canciones.equals(other.canciones))
			return false;
		if (idPlaylist != other.idPlaylist)
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
