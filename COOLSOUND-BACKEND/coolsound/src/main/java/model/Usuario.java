package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author raban 
 * Clase Usuarios
 * 
 */
@Entity
@Table(name = "Usuarios")
public class Usuario {

	/** Codigo del usuario */
	@Id
	@Column(name = "codusu")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int CodUsu;

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

	/** Getter del Codigo del Usuario */
	public int getCodUsu() {
		return CodUsu;
	}

	/** Setter del Codigo del Usuario */
	public void setCodUsu(int codUsu) {
		CodUsu = codUsu;
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

	/** Getter de la Imagen del Usuario*/
	public String getImagen() {
		return imagen;
	}

	/** Setter de la Imagen del Usuario */
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	/** Constructor de la clase Usuario */
	public Usuario(int codUsu, String nombre, String correo, String contraseña, int rol, String imagen) {
		super();
		CodUsu = codUsu;
		this.nombre = nombre;
		this.correo = correo;
		this.contraseña = contraseña;
		this.rol = rol;
		this.imagen = imagen;
	}
	
	/** ToString de la clase Usuario */
	@Override
	public String toString() {
		return "Usuario [CodUsu=" + CodUsu + ", nombre=" + nombre + ", correo=" + correo + ", contraseña=" + contraseña
				+ ", rol=" + rol + ", imagen=" + imagen + "]";
	}	
}
