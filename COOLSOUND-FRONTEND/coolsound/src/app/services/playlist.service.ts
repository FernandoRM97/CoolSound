import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Playlist } from '../model/playlist';

@Injectable({
  providedIn: 'root'
})
export class PlaylistService {

  private baseUrl = '/playlist/';

  constructor(private http: HttpClient) { }

  /** Método para sacar las canciones de BD */
  playlist(): Observable<any> {
    return this.http.get<Playlist>(`${this.baseUrl}` + 'getPlaylists/');
  }

  /** Método para añadir Comentarios a BD */
  nuevaPlaylist(texto: string, idUsuario: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'nuevaPlaylist/' + texto + '/' + idUsuario);
  }

  /** Método para eliminar Playlists de BD */
  eliminarPlaylist(idPlaylist: number): Observable<any> {
    return this.http.get(`${this.baseUrl}` + 'eliminarPlaylist/' + idPlaylist);
  }
}
