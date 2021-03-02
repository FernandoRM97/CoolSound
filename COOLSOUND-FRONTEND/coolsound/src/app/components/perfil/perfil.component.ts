import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  nombre;
  correo;
  url;

  constructor() { 
  }

  ngOnInit() {
    let usuario = JSON.parse(sessionStorage.getItem('usuario'));
    this.nombre = usuario.nombre;
    this.correo = usuario.correo;
    this.url = usuario.imagen;
  }

}
