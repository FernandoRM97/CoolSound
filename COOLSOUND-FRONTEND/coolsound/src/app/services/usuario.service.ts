import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Usuario} from '../model/usuario';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})

export class UsuarioService {

  private baseUrl = '/usuarios/';

  user: Usuario = new Usuario();
  usuario: Usuario = new Usuario();

  constructor(private http: HttpClient, private router: Router) { }

  /** Método para loguearse, guardando los datos de un usuario en el sessionStorage */

   loginUsuario(nombre: string, clave: string): Observable<Usuario> {
    console.log('DENTRO DEL SERVICIO' ,nombre, clave);
    this.http.get<Usuario>(`${this.baseUrl}` + 'login/' + nombre + '/' + clave)
    .subscribe( data => {
      console.log('TEST DESDE SERVICIO', data);
      this.user = data;
      if (this.user !== null) {
        sessionStorage.setItem('usuario', JSON.stringify(this.user));
        location.reload();
      }
    },
       error => {
        console.log('Error al recibir el usuario.', error);
      });

    return this.http.get<Usuario>(`${this.baseUrl}` + 'login/' + nombre + '/' + clave);
  }

  /** Método para comprobar si un usuario está logueado */

  isUserLoggedIn() {
    let usuario ;
    usuario = sessionStorage.getItem('usuario');
    return usuario;
  }

  /** Método para cerrar sesión en la página */

  logOut() {
    sessionStorage.removeItem('usuario');
    this.router.navigate(['home']);
  }

  /** Método para añadir un nuevo usuario */

  addNewUsuario(user: Usuario): Observable<any> {
      return this.http.post(`${this.baseUrl}addusuario`, user);
  }
 
  /** Método para cambiar la imagen de un usuario */
  changeUrl(id: number, url: string){
    return this.http.get(`${this.baseUrl}changeUrl/` + id + '/' + url);
  }

  /** Método para cambiar la contrasela de un usuario*/
  changePass(id: number, pass: string){
    return this.http.get(`${this.baseUrl}changePass/` + id + '/' + pass);
  }

  /** Método para sacar todos los usuarios de BD */
  getAllUsuarios() : Observable<any>{
    return this.http.get(`${this.baseUrl}` + 'getusuarios');
  }

    /** Método para eliminar Usuarios de BD */
    eliminarUsuario(idUsuario: number): Observable<any> {
      return this.http.get(`${this.baseUrl}` + 'eliminarUsuario/' + idUsuario);
    }
}
