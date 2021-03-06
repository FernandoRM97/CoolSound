import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './components/home/home.component';
import { LoginComponent} from './components/login/login.component';
import { AboutComponent } from './components/about/about.component';
import { CategoriesComponent } from './components/categories/categories.component';
import { CarouselComponent } from './components/carousel/carousel.component';
import { FormsModule } from '@angular/forms';
import { UsersComponent } from './components/users/users.component';
import { RegisterComponent } from './components/register/register.component';
import { ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { MusicaComponent } from './components/musica/musica.component';
import { NgxPaginationModule } from 'ngx-pagination';
import { MimusicaComponent } from './components/mimusica/mimusica.component';
import { PerfilComponent } from './components/perfil/perfil.component';
import { NuevaImagenComponent } from './components/nueva-imagen/nueva-imagen.component';
import { CambiarContrasenaComponent } from './components/cambiar-contrasena/cambiar-contrasena.component';
import { ForoComponent } from './components/foro/foro.component';
import { NuevoHiloComponent } from './components/nuevo-hilo/nuevo-hilo.component';
import { HiloComponent } from './components/hilo/hilo.component';
import { AdministracionComponent } from './components/administracion/administracion.component';
import { GestionUsuariosComponent } from './components/gestion-usuarios/gestion-usuarios.component';
import { GestionCancionesComponent } from './components/gestion-canciones/gestion-canciones.component';
import { PlaylistComponent } from './components/playlist/playlist.component';
import { NuevacancionComponent } from './components/nuevacancion/nuevacancion.component';
import { PlaylistDetallesComponent } from './components/playlist-detalles/playlist-detalles.component';
import { MusicadetalleComponent } from './components/musicadetalle/musicadetalle.component';

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    AboutComponent,
    CategoriesComponent,
    CarouselComponent,
    UsersComponent,
    RegisterComponent,
    LoginComponent,
    MusicaComponent,
    MimusicaComponent,
    PerfilComponent,
    NuevaImagenComponent,
    CambiarContrasenaComponent,
    ForoComponent,
    NuevoHiloComponent,
    HiloComponent,
    AdministracionComponent,
    GestionUsuariosComponent,
    GestionCancionesComponent,
    PlaylistComponent,
    NuevacancionComponent,
    PlaylistDetallesComponent,
    MusicadetalleComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    NgbModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    NgxPaginationModule
    ],
  providers: [ ],
  bootstrap: [AppComponent]
})
export class AppModule { }
