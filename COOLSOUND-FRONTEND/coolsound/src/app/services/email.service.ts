import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  private baseUrl = '/email/';

  constructor(private http: HttpClient, private router: Router) {}

  enviarMail(nombre: string, mail: string, mensaje: string): Observable<any>{
    console.log(`${this.baseUrl}` + 'enviar/' + nombre + '/' + mail + '/' + mensaje);
    return this.http.get(`${this.baseUrl}` + 'enviar/' + nombre + '/' + mail + '/' + mensaje);
  }
}
