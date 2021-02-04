import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import Swal from 'sweetalert2';


@Component({
  selector: 'app-phone',
  templateUrl: './phone.component.html',
  styleUrls: ['./phone.component.scss']
})
export class PhoneComponent implements OnInit {

  movil: any;
  id: any;

  constructor(private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
  }

  alerta() {
    Swal.fire({
      icon: 'success',
      title: 'Genial',
      text: 'Compra realizada con éxito',
    });
    this.router.navigate(['/']);
  }
}
