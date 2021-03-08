import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { NgbCarouselConfig } from '@ng-bootstrap/ng-bootstrap';
import { Cancion } from 'src/app/model/cancion';
import { CancionService } from 'src/app/services/cancion.service';
import { DomSanitizer, SafeResourceUrl, SafeUrl} from '@angular/platform-browser';

@Component({
  selector: 'app-playlist-detalles',
  templateUrl: './playlist-detalles.component.html',
  styleUrls: ['./playlist-detalles.component.scss']
})
export class PlaylistDetallesComponent implements OnInit {
  
  canciones: Cancion[];

  constructor(private _route:ActivatedRoute, config: NgbCarouselConfig, private cs: CancionService, private sanitizer: DomSanitizer) {
    config.showNavigationIndicators = true;
    config.interval = 0;
    config.wrap = true;
    config.keyboard = false;
    config.pauseOnHover = true;
  }
  ngOnInit() {
    let idPlaylist = this._route.snapshot.paramMap.get('idPlaylist');

    this.cs.cancionesPlaylist(idPlaylist).subscribe(data => {
      console.log(data);
      this.canciones = data;
    });
    
  }

}
