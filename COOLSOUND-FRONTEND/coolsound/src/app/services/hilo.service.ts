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

  /** Método para sacar las canciones de BD */
  hilos(): Observable<any> {
    return this.http.get<Hilo>(`${this.baseUrl}` + 'getHilos/');
  }
}
