import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Cancion } from 'src/app/model/cancion';
import { CancionService } from 'src/app/services/cancion.service';

@Component({
  selector: 'app-gestion-canciones',
  templateUrl: './gestion-canciones.component.html',
  styleUrls: ['./gestion-canciones.component.scss']
})
export class GestionCancionesComponent implements OnInit {

  canciones: Cancion[];
  
  constructor(private cs: CancionService, private router : Router) { 
  }

  ngOnInit() {
    this.cs.cancion().subscribe( data => {
      this.canciones = data;
    });
  }

 eliminar(idCancion : number):void {
    this.cs.eliminarCancion(idCancion).subscribe();
    location.reload();
  }
}
