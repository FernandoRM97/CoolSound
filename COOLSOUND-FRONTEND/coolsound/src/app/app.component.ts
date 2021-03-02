import { Component, OnInit } from '@angular/core';
import { UsuarioService } from './services/usuario.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})

export class AppComponent {
  navbarOpen = false;

  rol: 0;
  nombre: any;
  url: any;

  constructor(private us: UsuarioService) {
    this.rol = 0;
  }
  
  ngOnInit() {
    let usuario = JSON.parse(sessionStorage.getItem('usuario'));  
    this.rol = usuario.rol;
    this.nombre = usuario.nombre;
    this.url = usuario.imagen;
  }

  logout(){
    this.us.logOut();
    this.rol = null;
    this.nombre = null;
  }

  toggleNavbar() {
    this.navbarOpen = !this.navbarOpen;
  }

}
