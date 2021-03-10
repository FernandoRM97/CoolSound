import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { Cancion } from 'src/app/model/cancion';
import { ComentarioCancion } from 'src/app/model/comentario-cancion';
import { CancionService } from 'src/app/services/cancion.service';
import { ComentarioService } from 'src/app/services/comentario.service';
import { ComentariocancionService } from 'src/app/services/comentariocancion.service';

@Component({
  selector: 'app-musicadetalle',
  templateUrl: './musicadetalle.component.html',
  styleUrls: ['./musicadetalle.component.scss']
})
export class MusicadetalleComponent implements OnInit {

  newForm = new FormGroup({
    texto: new FormControl('', [Validators.required]),
    url: new FormControl('', [Validators.required])
  });

  id;
  rol;
  idUsuario;
  canciones: Cancion[];
  comentarios: ComentarioCancion[];

  constructor(private _route:ActivatedRoute, private cs: CancionService, private sanitizer: DomSanitizer, private ccs: ComentariocancionService) { }

  ngOnInit() {
    this.id = this._route.snapshot.paramMap.get('idCancion');
    console.log(this.id);

    let usuario = JSON.parse(sessionStorage.getItem('usuario'));  
    this.rol = usuario.rol;
    this.idUsuario = usuario.idUsuario;

    this.cs.unaCancion(this.id).subscribe(data => {
      this.canciones = data;
    })

    this.ccs.comentario(this.id).subscribe( data => {
      console.log(data);
      this.comentarios =data;
    })

  }

  eliminar(idComentarioCancion : number):void {
    this.ccs.eliminarComentario(idComentarioCancion).subscribe();
    location.reload();
  }

  nuevoComentario(){
    let text = this.texto.value;
    let cancion = this.id;
    this.ccs.nuevoComentario(text, this.idUsuario, cancion).subscribe();
    location.reload();
  }

  nuevaFoto(form){
    this.cs.cambiarFoto(this.id, form.value.url).subscribe();
    location.reload();
  }

  get texto() {
    return this.newForm.get('texto');
  }

  get url() {
    return this.newForm.get('url');
  }
}
