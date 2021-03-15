import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comentario } from '../model/comentario';

@Injectable({
  providedIn: 'root'
})

export class ComentarioService {

  private baseUrl = '/coolsound/comentarios/';

  constructor(private http: HttpClient) { }

  /** Método para sacar las canciones de BD */
  comentario(): Observable<any> {
    return this.http.get<Comentario>(`${this.baseUrl}` + 'getComentarios/');
  }

  /** Método para eliminar Comentarios de BD */
  eliminarComentario(idComentario: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'eliminarComentario/' + idComentario);
  }

  /** Método para añadir Comentarios a BD */
  nuevoHilo(idHilo: number, texto: string, idUsuario: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'nuevoComentario/' + idHilo + '/' + texto + '/' + idUsuario);
  }
}
