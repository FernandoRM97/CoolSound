import { Component, OnInit } from '@angular/core';
import { Hilo } from 'src/app/model/hilo';
import { HiloService } from 'src/app/services/hilo.service';

@Component({
  selector: 'app-foro',
  templateUrl: './foro.component.html',
  styleUrls: ['./foro.component.scss']
})
export class ForoComponent implements OnInit {

  public p: number = 1;
  hilos: Hilo[];
  rol;

  constructor(private hs: HiloService) { 
    this.hilos = [];
  }

  ngOnInit() {
    this.hs.hilos().subscribe(data => {
      this.hilos = data;
      console.log(this.hilos);
    });

    let usuario = JSON.parse(sessionStorage.getItem('usuario'));  
    this.rol = usuario.rol;
  }
  
  eliminar(idHilo : number):void {
    this.hs.eliminarHilo(idHilo).subscribe();
    location.reload();
  }
}
