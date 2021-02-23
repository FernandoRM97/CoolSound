import { Component, OnInit } from '@angular/core';
import { Cancion } from 'src/app/model/cancion';
import { Usuario } from 'src/app/model/usuario';
import { CancionService } from 'src/app/services/cancion.service';
import { UsuarioService } from 'src/app/services/usuario.service';

@Component({
  selector: 'app-mimusica',
  templateUrl: './mimusica.component.html',
  styleUrls: ['./mimusica.component.scss']
})
export class MimusicaComponent implements OnInit {

  public p: number = 1;
  canciones: Cancion[];
  user: any;

  constructor(private cs: CancionService, private us: UsuarioService) { 
    this.canciones = [];
  }

  ngOnInit() {

    this.user = JSON.parse(sessionStorage.getItem('usuario'));
    
    this.cs.miCancion(this.user.idUsuario ).subscribe(data => {
      this.canciones = data;

    })
  }

}
