import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { EmailService } from 'src/app/services/email.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-about',
  templateUrl: './about.component.html',
  styleUrls: ['./about.component.scss']
})
export class AboutComponent implements OnInit {

  // tslint:disable-next-line: max-line-length
  private emailPattern: any = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

  constructor(private router: Router, private es: EmailService) {
    this.contactForm = this.createFormGroup();
   }

  public contactForm: FormGroup;

  createFormGroup() {
    return new FormGroup({
      email: new FormControl('', [Validators.required, Validators.minLength(5), Validators.pattern(this.emailPattern)]),
      name: new FormControl('', [Validators.required, Validators.minLength(5)]),
      message: new FormControl('', [Validators.required, Validators.minLength(20), Validators.maxLength(200)])
    });
  }

  ngOnInit() {
  }

  onResetForm() {
  this.contactForm.reset();
  }

  onSaveForm(form) {
    const nombre = document.getElementById('name').value;
    const correo = document.getElementById('email').value;
    const mensaje = document.getElementById('message').value;

    if (this.contactForm.valid) {
      this.router.navigate(['home']);
      this.onResetForm();
      console.log('FWFWFWEFWEF', nombre, correo, mensaje);
      this.es.enviarMail(nombre , correo, mensaje).subscribe(data => {
        Swal.fire({
          icon: 'success',
          title: 'Mensaje enviado con éxito.',
          showConfirmButton: false,
          timer: 1500
        });
        this.contactForm.reset();
      }, error => {
        Swal.fire({
          icon: 'error',
          title: 'Lo sentimos, ha ocurrido un problema al enviar el mensaje.',
          text: 'Inténtelo de nuevo o mas tarde.',
          timer: 1500
        });
      });
    }

  }

  get name() { 
    return this.contactForm.get('name'); 
  }

  get email() { 
    return this.contactForm.get('email');
  }

  get message() { 
    return this.contactForm.get('message'); 
  }

}
