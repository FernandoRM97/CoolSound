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
 * @author raban Clase Hilo
 * 
 */
@Entity
@Table(name = "Hilo")
public class Hilo {

	/** Codigo del Hilo */
	@Id
	@Column(name = "HILO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHilo;

	/** Nombre del Hilo */
	@Column(name = "NOMBRE", unique = true)
	@NotNull
	private String nombre;

	/** Usuario */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;

	/** Comentarios del Hilo */
	@OneToMany(mappedBy = "hilo", cascade = CascadeType.ALL)
	private Set<Comentario> comentarios = new HashSet<Comentario>();

	/** Getter del Id del Hilo */
	public int getIdHilo() {
		return idHilo;
	}

	/** Setter del Id del Hilo */
	public void setIdHilo(int idHilo) {
		this.idHilo = idHilo;
	}

	/** Getter del Nombre del Hilo */
	public String getNombre() {
		return nombre;
	}

	/** Setter del Nombre del Hilo */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/** Getter del Usuario */
	public Usuario getUsuario() {
		return usuario;
	}

	/** Setter del Usuario */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/** Getter del Comentario */
	public Set<Comentario> getComentarios() {
		return comentarios;
	}

	/** Setter del Comentario */
	public void setComentarios(Set<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	/** Constructor de la clase Hilo */
	public Hilo(int idHilo, String nombre, Usuario usuario, Set<Comentario> comentarios) {
		super();
		this.idHilo = idHilo;
		this.nombre = nombre;
		this.usuario = usuario;
		this.comentarios = comentarios;
	}

	/** ToString de la clase Hilo */
	@Override
	public String toString() {
		return "Hilo [idHilo=" + idHilo + ", nombre=" + nombre + ", usuario=" + usuario + ", comentarios=" + comentarios
				+ "]";
	}

	/** HashCode de la clase Hilo */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comentarios == null) ? 0 : comentarios.hashCode());
		result = prime * result + idHilo;
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/** Equals de la clase Hilo */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hilo other = (Hilo) obj;
		if (comentarios == null) {
			if (other.comentarios != null)
				return false;
		} else if (!comentarios.equals(other.comentarios))
			return false;
		if (idHilo != other.idHilo)
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
