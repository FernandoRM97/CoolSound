import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { DomSanitizer } from '@angular/platform-browser';
import { ActivatedRoute } from '@angular/router';
import { Cancion } from 'src/app/model/cancion';
import { ComentarioCancion } from 'src/app/model/comentario-cancion';
import { Playlist } from 'src/app/model/playlist';
import { CancionService } from 'src/app/services/cancion.service';
import { ComentariocancionService } from 'src/app/services/comentariocancion.service';
import { PlaylistService } from 'src/app/services/playlist.service';
import Swal from 'sweetalert2';

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
  valoracion: any;
  vecesValorada: number;
  rol;
  idUsuario;
  canciones: Cancion[];
  cancion: Cancion;
  comentarios: ComentarioCancion[];
  playlists: Playlist[];

  constructor(private _route:ActivatedRoute, private cs: CancionService, private sanitizer: DomSanitizer, 
    private ccs: ComentariocancionService, private ps: PlaylistService) { }

  ngOnInit() {
    this.id = this._route.snapshot.paramMap.get('idCancion');
    console.log(this.id);
    this.valoracion = this._route.snapshot.paramMap.get('valoracion');
    console.log(this.valoracion);
    this.vecesValorada = Number(this._route.snapshot.paramMap.get('vecesValorada'));
    console.log(this.vecesValorada);

    this.cs.vecesEscuchada(this.id).subscribe();

    let usuario = JSON.parse(sessionStorage.getItem('usuario'));  
    this.rol = usuario.rol;
    this.idUsuario = usuario.idUsuario;

    this.cs.unaCancion(this.id).subscribe(data => {
      this.canciones = data;
    })

    this.ccs.comentario(this.id).subscribe( data => {
      this.comentarios = data;
    })

    this.ps.playlistByUser(this.idUsuario).subscribe( data => {
      this.playlists = data;
    })

  }

  valorar(){
    var valorar = (<HTMLInputElement>document.getElementById('valorar')).value;
    var vecesValorada2: number;

    vecesValorada2 = this.vecesValorada + 1;
    console.log("VECES VALORADA" + vecesValorada2);
    this.valoracion = (Number(valorar) + Number(this.valoracion)) / vecesValorada2;
    console.log("MEDIA" + this.valoracion);

    this.cs.changeValoracion(this.valoracion, vecesValorada2, this.id).subscribe(data=> {
      Swal.fire({
        icon: 'success',
        title: 'Valoración añadida con éxito.',
        showConfirmButton: false,
        timer: 1500
      });
    });
    location.reload();
    
  }

  eliminar(idComentarioCancion : number):void {
    this.ccs.eliminarComentario(idComentarioCancion).subscribe(data => {
      Swal.fire({
        icon: 'success',
        title: 'Comentario eliminado con éxito.',
        showConfirmButton: false,
        timer: 1500
      });
    });
    location.reload();
  }

  nuevoComentario(){
    let text = this.texto.value;
    let cancion = this.id;
    this.ccs.nuevoComentario(text, this.idUsuario, cancion).subscribe(data => {
      Swal.fire({
        icon: 'success',
        title: 'Comentario añadido con éxito.',
        showConfirmButton: false,
        timer: 1500
      });
    });
    location.reload();
  }

  nuevaFoto(form){
    this.cs.cambiarFoto(this.id, form.value.url).subscribe(data => {
      Swal.fire({
        icon: 'success',
        title: 'Portada cambiada con éxito.',
        showConfirmButton: true,
        timer: 1500
      });
    });
    location.reload();
  }

  playlist(){
    var idPlaylist = (<HTMLInputElement>document.getElementById('anadir')).value;
    var idPlaylist2 = Number(idPlaylist)
    
    this.cs.changePlaylist(this.id, idPlaylist2).subscribe(data => {
      Swal.fire({
        icon: 'success',
        title: 'Videoclip añadido a Playlist con éxito.',
        showConfirmButton: false,
        timer: 1500
      });
    })
  } 
  
  get texto() {
    return this.newForm.get('texto');
  }

  get url() {
    return this.newForm.get('url');
  }
}
