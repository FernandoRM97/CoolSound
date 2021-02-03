import { Component, OnInit } from '@angular/core';
import { FireDbService } from '../../fire-db.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  lista: string[] = ['/assets/cancionprueba.jpg', '/assets/cancionprueba.jpg',
  '/assets/cancionprueba.jpg', '/assets/cancionprueba.jpg'];

  constructor(public db: FireDbService) { }

  ngOnInit() {

  }

}
