import { Component, OnInit } from '@angular/core';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import { Router } from '@angular/router';
import Swal from 'sweetalert2';
import { UsuarioService } from '../usuario.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  submitted = false;
  mensaje = false;
  userForm = new FormGroup({
    nombre: new FormControl('', [Validators.required]),
    clave: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  constructor(private us: UsuarioService, private router: Router) { }

  ngOnInit() {
    this.submitted = false;
  }

  /** Método para loguearse un usuario */
  
  public userLogin(form) {
    this.us.loginUsuario(form.value.nombre, form.value.clave)
      .subscribe( data => {
        if (data === null) {
          Swal.fire({
            icon: 'error',
            title: 'Lo sentimos, ha ocurrido un problema al iniciar sesión',
            text: 'Nombre de usuario o contraseña incorrectos.',
          });
          this.userForm.reset();
        } else {
          if (form.value.clave !== data.contraseña && form.value.nombre !== data.nombre) {
            Swal.fire({
              icon: 'error',
              title: 'Lo sentimos, ha ocurrido un problema al iniciar sesión',
              text: 'Nombre de usuario o contraseña incorrectos.',
            });
            this.userForm.reset();
          } else {
              this.router.navigate(['home']);
          }
        }
      }, error => console.log(error));
    }
    
  get nombre() {
    return this.userForm.get('nombre');
  }
  get clave() {
    return this.userForm.get('clave');
  }

}
