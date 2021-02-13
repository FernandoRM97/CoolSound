import { Component, OnInit } from '@angular/core';
import { UsuarioService } from './usuario.service';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
})

export class AppComponent {
  navbarOpen = false;

  rol: any;
  nombre: any;

  constructor(private us: UsuarioService) {}
  
  ngOnInit() {
    let usuario = JSON.parse(sessionStorage.getItem('usuario'));  
    this.rol = usuario.rol;
    this.nombre = usuario.nombre;
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
