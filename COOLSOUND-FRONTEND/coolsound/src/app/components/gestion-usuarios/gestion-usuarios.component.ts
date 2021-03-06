import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-gestion-usuarios',
  templateUrl: './gestion-usuarios.component.html',
  styleUrls: ['./gestion-usuarios.component.scss']
})
export class GestionUsuariosComponent implements OnInit {

  usuarios: Usuario[];
  
  constructor(private us: UsuarioService, private router : Router) { 
  }

  ngOnInit() {
    this.us.getAllUsuarios().subscribe( data => {
      this.usuarios = data;
    });
  }

  eliminar(idUsuario : number):void {
    this.us.eliminarUsuario(idUsuario).subscribe();
    location.reload();
  }
}
