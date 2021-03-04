import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Hilo } from '../model/hilo';

@Injectable({
  providedIn: 'root'
})
export class HiloService {

  private baseUrl = '/hilo/';

  constructor(private http: HttpClient) { }

  /** Método para sacar los Hilos de BD */
  hilos(): Observable<any> {
    return this.http.get<Hilo>(`${this.baseUrl}` + 'getHilos/');
  }

  /** Método para eliminar Hilos de BD */
  eliminarHilo(idHilo: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'eliminarHilo/' + idHilo);
  }

  /** Método para añadir Hilos a BD */
  nuevoHilo(nombreHilo: string, idUsuario: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'nuevoHilo/' + nombreHilo + '/' + idUsuario);
  }
}
