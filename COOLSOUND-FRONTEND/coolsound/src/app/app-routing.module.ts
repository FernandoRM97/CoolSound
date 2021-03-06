import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { HomeComponent } from './components/home/home.component';
import { AboutComponent } from './components/about/about.component';
import { CategoriesComponent } from './components/categories/categories.component';
import { RegisterComponent } from './components/register/register.component';
import { LoginComponent } from './components/login/login.component';
import { MusicaComponent } from './components/musica/musica.component';
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

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'home', component: HomeComponent},
  { path: 'about', component: AboutComponent},
  { path: 'categories', component: CategoriesComponent},
  { path: 'register', component: RegisterComponent},
  { path: 'login', component: LoginComponent},
  { path: 'musica', component: MusicaComponent},
  { path: 'mimusica', component: MimusicaComponent},
  { path: 'perfil', component: PerfilComponent},
  { path: 'perfil/nuevaImagen', component: NuevaImagenComponent},
  { path: 'perfil/nuevaImagen/home', component: HomeComponent},
  { path: 'perfil/cambiarContrasena', component: CambiarContrasenaComponent},
  { path: 'perfil/cambiarContrasena/home', component: HomeComponent},
  { path: 'foro', component: ForoComponent},
  { path: 'foro/nuevoHilo', component: NuevoHiloComponent},
  { path: 'foro/nuevoHilo/home', component: HomeComponent},
  { path: 'hilo/:idHilo/:nombre', component: HiloComponent},
  { path: 'administracion', component: AdministracionComponent},
  { path: 'about/register', component: RegisterComponent},
  { path: 'administracion/gestionUsuarios', component: GestionUsuariosComponent},
  { path: 'administracion/gestionCanciones', component: GestionCancionesComponent},
  { path: 'gestionUsuarios', component: GestionUsuariosComponent},
  { path: 'gestionUsuarios/administracion', component: AdministracionComponent},
  { path: 'gestionUsuarios/administracion/gestionUsuarios', component: GestionUsuariosComponent},
  { path: 'administracion/gestionUsuarios/administracion', component: AdministracionComponent},
  { path: 'administracion/gestionCanciones/administracion', component: AdministracionComponent},
  { path: 'gestionCanciones', component: GestionCancionesComponent},
  { path: 'administracion/gestionCanciones/administracion/gestionUsuarios', component: GestionUsuariosComponent},
  { path: 'administracion/gestionUsuarios/administracion/gestionCanciones', component: GestionCancionesComponent},
  { path: 'playlist', component: PlaylistComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
