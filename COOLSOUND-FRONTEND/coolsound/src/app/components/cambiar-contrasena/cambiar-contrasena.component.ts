import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Usuario } from 'src/app/model/usuario';
import { UsuarioService } from 'src/app/services/usuario.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cambiar-contrasena',
  templateUrl: './cambiar-contrasena.component.html',
  styleUrls: ['./cambiar-contrasena.component.scss']
})
export class CambiarContrasenaComponent implements OnInit {

  changePassForm = new FormGroup({
    pass: new FormControl('', [Validators.required]),
    pass2: new FormControl('', [Validators.required]),
    pass3: new FormControl('', [Validators.required]),
  });

  rol: 0;
  nombre: any;
  contraseñaActual;
  usuario: Usuario;
  id;

  constructor(private us: UsuarioService, private router: Router) { }

  ngOnInit() {
  }

  public changePass(form){
    this.usuario = JSON.parse(sessionStorage.getItem('usuario'));
    this.id = this.usuario.idUsuario;
    this.contraseñaActual = this.usuario.contraseña;

      if(this.changePassForm.value.pass2 == this.changePassForm.value.pass3){
        this.us.changePass(this.id, this.changePassForm.value.pass2).subscribe( data => {
          if (data != null){
            Swal.fire({
              icon: 'error',
              title: 'Error al cambiar la contraseña.',
              text: 'Error al cambiar la contraseña.',
              timer: 1500
            });
            this.changePassForm.reset();
          } else {
            Swal.fire({
              icon: 'success',
              title: 'Se ha cambiado la contraseña correctamente',
              text: 'Contraseña cambiada correctamente.',
              timer: 1500
            });
            this.changePassForm.reset();
          }
          this.logout();
        })
          this.router.navigate(['home']);
        } else if (this.changePassForm.value.pass2 != this.changePassForm.value.pass || this.changePassForm.value.pass3 != this.changePassForm.value.pass3 
          || this.changePassForm.value.pass !== this.contraseñaActual){
        Swal.fire({
          icon: 'error',
          title: 'Las contraseñas no coinciden.',
          text: 'Contraseñas incorrectas.',
          timer: 1500
        });
        this.changePassForm.reset();
      } else {
        Swal.fire({
          icon: 'error',
          title: 'Las contraseñas no coinciden.',
          text: 'Contraseñas incorrectas.',
          timer: 1500
        });
        this.changePassForm.reset();
      }
  }


  logout(){
    this.us.logOut();
    this.rol = null;
    this.nombre = null;
    window.location.reload();
  }

  get pass() {
    return this.changePassForm.get('pass');
  }

  get pass2() {
    return this.changePassForm.get('pass');
  }

  get pass3() {
    return this.changePassForm.get('pass');
  }

}
