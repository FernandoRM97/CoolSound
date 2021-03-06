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

  /** Método para eliminar Usuarios de BD */
  eliminarCancion(idCancion: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'eliminarcancion/' + idCancion);
  }
}

