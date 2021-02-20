package com.java.coolsound.model;

import java.io.Serializable;
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
 * @author raban Clase Cancion
 * 
 */
@Entity
@Table(name = "Canciones")
public class Cancion implements Serializable{

	private static final long serialVersionUID = 1L;
	
	/** Codigo de la Cancion */
	@Id
	@Column(name = "CANCION_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idCancion;

	/** Titulo de la Cancion */
	@Column(name = "TITULO", unique = true)
	@NotNull
	private String titulo;

	/** Genero de la Cancion */
	@Column(name = "GENERO", unique = true)
	@NotNull
	private String genero;

	/** Musica de la Cancion */
	@Column(name = "MUSICA", unique = true)
	@NotNull
	private String musica;

	/** Portada de la Cancion */
	@Column(name = "PORTADA", unique = true)
	@NotNull
	private String portada;

	/** Valoracion de la Cancion */
	@Column(name = "VALORACION", unique = true)
	@NotNull
	private double valoracion;

	/** Veces que se escucha la Cancion */
	@Column(name = "vecesEscuchada", unique = true)
	@NotNull
	private double vecesEscuchada;

	/** Usuario */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;

	/** Playlist */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "PLAYLIST_ID")
	private Playlist playlist;

	/** Comentarios de Canciones */
	@OneToMany(mappedBy = "cancion", cascade = CascadeType.ALL)
	private Set<ComentarioCancion> ComentarioCanciones = new HashSet<ComentarioCancion>();

	/** Getter de la Id de la Cancion */
	public int getIdCancion() {
		return idCancion;
	}

	/** Setter de la Id de la Cancion */
	public void setIdCancion(int idCancion) {
		this.idCancion = idCancion;
	}

	/** Getter del titulo de la Cancion */
	public String getTitulo() {
		return titulo;
	}

	/** Setter del titulo de la Cancion */
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	/** Getter del genero de la Cancion */
	public String getGenero() {
		return genero;
	}

	/** Setter del genero de la Cancion */
	public void setGenero(String genero) {
		this.genero = genero;
	}

	/** Getter de la Musica */
	public String getMusica() {
		return musica;
	}

	/** Setter de la Cancion */
	public void setMusica(String musica) {
		this.musica = musica;
	}

	/** Getter de la Portada */
	public String getPortada() {
		return portada;
	}

	/** Setter de la portada */
	public void setPortada(String portada) {
		this.portada = portada;
	}

	/** Getter del Id del Usuario */
	public Usuario getIdUsuario() {
		return usuario;
	}

	/** Setter del Id del Usuario */
	public void setIdUsuario(Usuario idUsuario) {
		this.usuario = idUsuario;
	}

	/** Getter de la Valoracion */
	public double getValoracion() {
		return valoracion;
	}

	/** Setter de la Valoracion */
	public void setValoracion(double valoracion) {
		this.valoracion = valoracion;
	}

	/** Getter del VecesEscuchada */
	public double getVecesEscuchada() {
		return vecesEscuchada;
	}

	/** Setter del VecesEscuchada */
	public void setVecesEscuchada(double vecesEscuchada) {
		this.vecesEscuchada = vecesEscuchada;
	}

	/** Getter del Usuario de la Cancion */
	public Usuario getUsuario() {
		return usuario;
	}

	/** Setter del Usuario de la Cancion */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/** Getter de la Playlist de la Cancion */
	public Playlist getPlaylist() {
		return playlist;
	}

	/** Setter de la Playlist de la Cancion */
	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	/** Getter de los Comentarios de la Cancion */
	public Set<ComentarioCancion> getComentarioCanciones() {
		return ComentarioCanciones;
	}

	/** Setter de los Comentarios de la Cancion */
	public void setComentarioCanciones(Set<ComentarioCancion> comentarioCanciones) {
		ComentarioCanciones = comentarioCanciones;
	}

	/** Constructor por defecto de la clase Cancion */
	public Cancion() {
		super();
	}

	/** Constructor de la clase Cancion */
	public Cancion(int idCancion, String titulo, String genero, String musica, String portada, double valoracion,
			Usuario usuario, double vecesEscuchada, Playlist playlist, Set<ComentarioCancion> comentarioCanciones) {
		super();
		this.idCancion = idCancion;
		this.titulo = titulo;
		this.genero = genero;
		this.musica = musica;
		this.portada = portada;
		this.valoracion = valoracion;
		this.usuario = usuario;
		this.vecesEscuchada = vecesEscuchada;
		this.playlist = playlist;
		ComentarioCanciones = comentarioCanciones;
	}

	/** ToString de la clase Cancion */
	@Override
	public String toString() {
		return "Cancion [idCancion=" + idCancion + ", titulo=" + titulo + ", genero=" + genero + ", musica=" + musica
				+ ", portada=" + portada + ", valoracion=" + valoracion + ", usuario=" + usuario + ", vecesEscuchada="
				+ vecesEscuchada + ", playlist=" + playlist + ", ComentarioCanciones=" + ComentarioCanciones + "]";
	}

	/** Hash Code la clase Cancion */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ComentarioCanciones == null) ? 0 : ComentarioCanciones.hashCode());
		result = prime * result + ((genero == null) ? 0 : genero.hashCode());
		result = prime * result + idCancion;
		result = prime * result + ((musica == null) ? 0 : musica.hashCode());
		result = prime * result + ((playlist == null) ? 0 : playlist.hashCode());
		result = prime * result + ((portada == null) ? 0 : portada.hashCode());
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valoracion);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(vecesEscuchada);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	/** Equals de la clase Cancion */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cancion other = (Cancion) obj;
		if (ComentarioCanciones == null) {
			if (other.ComentarioCanciones != null)
				return false;
		} else if (!ComentarioCanciones.equals(other.ComentarioCanciones))
			return false;
		if (genero == null) {
			if (other.genero != null)
				return false;
		} else if (!genero.equals(other.genero))
			return false;
		if (idCancion != other.idCancion)
			return false;
		if (musica == null) {
			if (other.musica != null)
				return false;
		} else if (!musica.equals(other.musica))
			return false;
		if (playlist == null) {
			if (other.playlist != null)
				return false;
		} else if (!playlist.equals(other.playlist))
			return false;
		if (portada == null) {
			if (other.portada != null)
				return false;
		} else if (!portada.equals(other.portada))
			return false;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		if (Double.doubleToLongBits(valoracion) != Double.doubleToLongBits(other.valoracion))
			return false;
		if (Double.doubleToLongBits(vecesEscuchada) != Double.doubleToLongBits(other.vecesEscuchada))
			return false;
		return true;
	}

}