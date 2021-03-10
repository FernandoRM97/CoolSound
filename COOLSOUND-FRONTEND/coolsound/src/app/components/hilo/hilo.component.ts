import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Comentario } from 'src/app/model/comentario';
import { ComentarioService } from 'src/app/services/comentario.service';

@Component({
  selector: 'app-hilo',
  templateUrl: './hilo.component.html',
  styleUrls: ['./hilo.component.scss']
})
export class HiloComponent implements OnInit {

  newForm = new FormGroup({
    texto: new FormControl('', [Validators.required]),
  });

  comentarios: Comentario[];
  id;
  rol;
  idHilo;
  nombreComentario;

  constructor(private _route:ActivatedRoute, private cs: ComentarioService, private router: Router) { }

  ngOnInit() {
    let id = this._route.snapshot.paramMap.get('idHilo');
    let nombre = this._route.snapshot.paramMap.get('nombre');
    this.idHilo = id;
    this.nombreComentario = nombre;

    console.log(nombre, id);

    this.cs.comentario().subscribe(data => {
      console.log(data);
      this.comentarios = data;
    });

    let usuario = JSON.parse(sessionStorage.getItem('usuario'));  
    this.id = usuario.idUsuario;
    this.rol = usuario.rol;
  }

  eliminar(idComentario : number):void {
    this.cs.eliminarComentario(idComentario).subscribe();
    location.reload();
  }

  nuevoComentario(){
    let text = this.texto.value;
    let user = this.id;
    let hilo = this.idHilo;
    this.cs.nuevoHilo(hilo,text,user).subscribe();
    location.reload();
  }

  get texto() {
    return this.newForm.get('texto');
  }
}
