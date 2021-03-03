import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/model/usuario';
import { HiloService } from 'src/app/services/hilo.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nuevo-hilo',
  templateUrl: './nuevo-hilo.component.html',
  styleUrls: ['./nuevo-hilo.component.scss']
})
export class NuevoHiloComponent implements OnInit {

  newForm = new FormGroup({
    hlo: new FormControl('', [Validators.required]),
  });

  rol: 0;
  nombre: any;
  id;
  usuario: Usuario;
  
  constructor(private hs: HiloService, private router: Router) { }

  ngOnInit() {
  }

  public nuevoHilo(form){

    this.usuario = JSON.parse(sessionStorage.getItem('usuario'));
    this.id = this.usuario.idUsuario;

    this.hs.nuevoHilo(this.newForm.value.hlo, this.id).subscribe( data => {
      if (data != null){
        Swal.fire({
          icon: 'success',
          title: 'Se ha añadido el nuevo Hilo correctamente',
          text: 'Hilo añadido correctamente.',
          timer: 1500
        });
        this.newForm.reset();
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Lo sentimos, ha ocurrido un problema al añadir el nuevo Hilo',
          text: 'Información incorrecta.',
          timer: 1500
        });
        this.newForm.reset();
      }
      })
      this.router.navigate(['foro']);
    }
 
  get hlo() {
    return this.newForm.get('hlo');
  }
}
