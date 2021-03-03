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
  { path: 'foro/nuevoHilo/home', component: HomeComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
