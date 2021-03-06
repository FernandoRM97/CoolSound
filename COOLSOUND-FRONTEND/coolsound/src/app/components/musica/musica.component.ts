import { Component, OnInit } from '@angular/core';
import { Cancion } from 'src/app/model/cancion';
import { CancionService} from '../../services/cancion.service';

@Component({
  selector: 'app-musica',
  templateUrl: './musica.component.html',
  styleUrls: ['./musica.component.scss']
})
export class MusicaComponent implements OnInit {

  public p: number = 1;
  canciones: Cancion[];

  constructor(private cs: CancionService) { 
    this.canciones = [];
  }

  ngOnInit() {
    this.cs.cancion().subscribe(data => {
      this.canciones = data;
      console.log(this.canciones);
    })
  }

}

