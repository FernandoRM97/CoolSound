import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-nueva-imagen',
  templateUrl: './nueva-imagen.component.html',
  styleUrls: ['./nueva-imagen.component.scss']
})
export class NuevaImagenComponent implements OnInit {

  changeForm = new FormGroup({
    url: new FormControl('', [Validators.required]),
  });

  rol: 0;
  nombre: any;
  id;
  usuario: Usuario;

  constructor(private us: UsuarioService, private router: Router) { }

  ngOnInit() {
  }

  public changeUrl(form){
    this.usuario = JSON.parse(sessionStorage.getItem('usuario'));
    this.id = this.usuario.idUsuario;
    this.us.changeUrl(this.id, this.changeForm.value.url).subscribe( data => {
      if (data != null){
        Swal.fire({
          icon: 'error',
          title: 'Lo sentimos, ha ocurrido un problema al cambiar la imagen',
          text: 'Url incorrecta.',
          timer: 1500
        });
        this.changeForm.reset();
      } else {
        Swal.fire({
          icon: 'success',
          title: 'Se ha cambiado la imagen correctamente',
          text: 'Imagen cambiada correctamente.',
          timer: 1500
        });
        this.changeForm.reset();
      }
      this.logout();
      })
      this.router.navigate(['home']);
    }

  logout(){
    this.us.logOut();
    this.rol = null;
    this.nombre = null;
    window.location.reload();
  }

  get url() {
    return this.changeForm.get('url');
  }
}
