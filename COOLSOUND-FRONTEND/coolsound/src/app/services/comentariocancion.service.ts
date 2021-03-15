import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Comentario } from '../model/comentario';

@Injectable({
  providedIn: 'root'
})
export class ComentariocancionService {

  private baseUrl = '/coolsound/comentarioCancion/';

  constructor(private http: HttpClient) { }

  /** Método para sacar los Comentarios de BD */
  comentario(id: number): Observable<any> {
    return this.http.get<Comentario>(`${this.baseUrl}` + 'getComentarioCancion/' + id);
  }

  /** Método para eliminar Comentarios de BD */
  eliminarComentario(idComentarioCancion: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'eliminarComentarioCancion/' + idComentarioCancion);
  }

  /** Método para añadir Comentarios a BD */
  nuevoComentario(texto: string, idUsuario: number, idCancion: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'nuevoComentarioCancion/' + texto + '/' + idUsuario + '/' + idCancion);
  }
}
