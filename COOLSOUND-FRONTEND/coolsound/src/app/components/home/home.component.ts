import { Component, OnInit } from '@angular/core';
import { Cancion } from 'src/app/model/cancion';
import { CancionService } from 'src/app/services/cancion.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {
  
  canciones: Cancion[];
  canciones2: Cancion[];
  
  constructor(private cs: CancionService) { 
  }
  
  ngOnInit() {
    this.cs.masEscuchadas().subscribe( data => {
      this.canciones = data;
    });

    this.cs.mejorValoradas().subscribe( data => {
      this.canciones2 = data;
    })
  }
  
}
