import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Cancion } from 'src/app/model/cancion';
import { Usuario } from 'src/app/model/usuario';
import { CancionService } from 'src/app/services/cancion.service';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nuevacancion',
  templateUrl: './nuevacancion.component.html',
  styleUrls: ['./nuevacancion.component.scss']
})
export class NuevacancionComponent implements OnInit {

  mensajeError = false;

  canc: Cancion = new Cancion();
  idUsu;

  registerForm = new FormGroup({
    titulo: new FormControl('', [Validators.required]),
    genero: new FormControl('', [Validators.required]),
    cancion: new FormControl('', [Validators.required])
  });

  
  constructor(private cs: CancionService, private router: Router) { }

  ngOnInit() {
  }

  /** Método para registrar una nueva cancion */

  addNewCancion(form) {
    let usuario = JSON.parse(sessionStorage.getItem('usuario'));  
    this.idUsu = usuario.idUsuario;

    var genero = (<HTMLInputElement>document.getElementById('genero')).value;

    this.canc.titulo = form.value.titulo;
    this.canc.valoracion = 0;
    this.canc.vecesEscuchada = 0;
    this.canc.cancion= form.value.cancion;
    this.canc.genero = genero;

    console.log(this.canc);

    this.cs.nuevaCancion(this.canc.titulo, this.canc.valoracion, this.canc.vecesEscuchada, this.canc.genero, this.idUsu,this.canc.cancion).subscribe();
    location.reload();
  }

  get titulo() {
    return this.registerForm.get('titulo');
  }
  get genero() {
    return this.registerForm.get('genero');
  }
  get cancion() {
    return this.registerForm.get('cancion');
  }

}
