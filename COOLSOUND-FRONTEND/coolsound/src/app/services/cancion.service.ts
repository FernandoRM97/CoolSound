import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Cancion } from '../model/cancion';

@Injectable({
  providedIn: 'root'
})
export class CancionService {

  private baseUrl = '/canciones/';

  constructor(private http: HttpClient) { }

  /** Método para sacar las canciones de BD */
  cancion(): Observable<any> {
    return this.http.get<Cancion>(`${this.baseUrl}` + 'getcanciones/');
  }

  /** Método para sacar las canciones de BD */
  miCancion(id: any): Observable<any> {
    return this.http.get<Cancion>(`${this.baseUrl}` + 'getcanciones/' + id);
  }

    /** Método para sacar las canciones de BD */
    unaCancion(id: any): Observable<any> {
      return this.http.get<Cancion>(`${this.baseUrl}` + 'getcancion/' + id);
    }

  /** Método para sacar las canciones de BD */
  cancionesPlaylist(idPlaylist: any): Observable<any> {
     return this.http.get<Cancion>(`${this.baseUrl}` + 'getCanciones/' + idPlaylist);
  }

  /** Método para eliminar Usuarios de BD */
  eliminarCancion(idCancion: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'eliminarcancion/' + idCancion);
  }

  /** Método para añadir Canciones a BD */
  nuevaCancion(titulo:string, valoracion:number, vecesEscuchada:number, genero:string, idUsu: number, cancion:string): Observable<any> {
    return this.http.get(`${this.baseUrl}nuevaCancion/` + titulo  + '/' + valoracion + '/' + vecesEscuchada + '/' + idUsu
    + '/' + genero + '/' + cancion);
  }

  /** Método para cambiar la imagen de una cancion */
  cambiarFoto(idCancion: number, url: string){
    return this.http.get(`${this.baseUrl}cambiarFoto/` + idCancion + '/' + url);
  }  

}

