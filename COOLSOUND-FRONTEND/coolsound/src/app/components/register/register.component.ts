import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators, NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { Usuario } from 'src/app/usuario';
import { UsuarioService } from 'src/app/usuario.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.scss']
})
export class RegisterComponent implements OnInit {

  mensajeError = false;
  usuario: Usuario = new Usuario();
  registerForm = new FormGroup({
    correo: new FormControl('', [Validators.required, Validators.pattern('[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$')]),
    nombre: new FormControl('', [Validators.required, Validators.minLength(6)]),
    clave: new FormControl('', [Validators.required, Validators.minLength(6)])
  });

  constructor(private us: UsuarioService, private router: Router) { }

  ngOnInit() {
  }

  /** Método para registrar un nuevo usuario */

  addNewUsuario(form) {
    this.usuario.correo = form.value.correo;
    this.usuario.nombre = form.value.nombre;
    this.usuario.contraseña = form.value.clave;
    this.usuario.rol = 1;

    this.us.addNewUsuario(this.usuario).subscribe(data => {
      Swal.fire({
        icon: 'success',
        title: 'Usuario registrado con éxito.',
        showConfirmButton: false,
        timer: 1500
      });
      this.registerForm.reset();
      this.router.navigate(['home']);
    }, error => {
      console.log('Error al añadir usuario', error);
      this.mensajeError = true;
      setTimeout(() => {
        this.mensajeError = false;
      }, 3000);
    });
  }

  get nombre() {
    return this.registerForm.get('nombre');
  }
  get correo() {
    return this.registerForm.get('correo');
  }
  get clave() {
    return this.registerForm.get('clave');
  }

}