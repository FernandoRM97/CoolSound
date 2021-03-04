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
 * @author raban Clase Comentario
 * 
 */
@Entity
@Table(name = "Comentario")
public class Comentario {

	/** Codigo del Comentario */
	@Id
	@Column(name = "COMENTARIO_ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idComentario;
	
	/** Texto del Comentario */
	@Column(name = "TEXTO", unique = true)
	@NotNull
	private String texto;
	
	/** Usuario */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "USUARIO_ID")
	private Usuario usuario;
	
	/** Hilo */
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "HILO_ID")
	private Hilo hilo;

	/** Getter del Id del Comentario */
	public int getIdComentario() {
		return idComentario;
	}

	/** Setter del Id del Comentario */
	public void setIdComentario(int idComentario) {
		this.idComentario = idComentario;
	}

	/** Getter del Texto del Comentario */
	public String getTexto() {
		return texto;
	}
 
	/** Setter del Texto del Comentario */
	public void setTexto(String texto) {
		this.texto = texto;
	}

	/** Getter del Usuario */
	public Usuario getUsuario() {
		return usuario;
	}

	/** Setter del Usuario */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	/** Getter del Hilo */
	public Hilo getHilo() {
		return hilo;
	}

	/** Setter del Hilo */
	public void setHilo(Hilo hilo) {
		this.hilo = hilo;
	}

	/** Constructor por defecto de la clase Comentario */
	public Comentario() {
		super();
	}

	/** Constructor de la clase Comentario*/
	public Comentario(int idComentario, String texto, Usuario usuario, Hilo hilo) {
		super();
		this.idComentario = idComentario;
		this.texto = texto;
		this.usuario = usuario;
		this.hilo = hilo;
	}

	/** ToString de la clase Comentario */
	@Override
	public String toString() {
		return "Comentario [idComentario=" + idComentario + ", texto=" + texto + ", usuario=" + usuario + ", hilo="
				+ hilo + "]";
	}

	/** HashCode de la clase Comentario */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hilo == null) ? 0 : hilo.hashCode());
		result = prime * result + idComentario;
		result = prime * result + ((texto == null) ? 0 : texto.hashCode());
		result = prime * result + ((usuario == null) ? 0 : usuario.hashCode());
		return result;
	}

	/** Equals de la clase Comentario */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Comentario other = (Comentario) obj;
		if (hilo == null) {
			if (other.hilo != null)
				return false;
		} else if (!hilo.equals(other.hilo))
			return false;
		if (idComentario != other.idComentario)
			return false;
		if (texto == null) {
			if (other.texto != null)
				return false;
		} else if (!texto.equals(other.texto))
			return false;
		if (usuario == null) {
			if (other.usuario != null)
				return false;
		} else if (!usuario.equals(other.usuario))
			return false;
		return true;
	}
	
}
