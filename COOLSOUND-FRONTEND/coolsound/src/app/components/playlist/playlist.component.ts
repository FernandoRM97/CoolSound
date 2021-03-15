import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Playlist } from 'src/app/model/playlist';
import { PlaylistService } from 'src/app/services/playlist.service';

@Component({
  selector: 'app-playlist',
  templateUrl: './playlist.component.html',
  styleUrls: ['./playlist.component.scss']
})
export class PlaylistComponent implements OnInit {

  newForm = new FormGroup({
    texto: new FormControl('', [Validators.required]),
  });

  playlists: Playlist[];
  id;
  idHilo;
  nombreComentario;

  constructor(private ps: PlaylistService, private router: Router) { }

  ngOnInit() {
    let usuario = JSON.parse(sessionStorage.getItem('usuario'));
    this.id = usuario.idUsuario;

    this.ps.playlist().subscribe(data => {
      console.log(data);
      this.playlists = data;
    });

  }

  eliminar(idPlaylist : number):void {
    this.ps.eliminarPlaylist(idPlaylist).subscribe();
    //location.reload();  
  }

  nuevaPlaylist(){
    let text = this.texto.value;
    let user = this.id;
    this.ps.nuevaPlaylist(text,user).subscribe();
    location.reload();  
  }

  get texto() {
    return this.newForm.get('texto');
  }
}
