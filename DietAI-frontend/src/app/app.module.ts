import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HeaderComponent } from './components/header/header.component';
import { BienvenidaComponent } from './components/bienvenida/bienvenida.component';
import { InfoComponent } from './components/info/info.component';
import { FooterComponent } from './components/footer/footer.component';
import { RegisterComponent } from './views/register/register.component';
import { LoginComponent } from './views/login/login.component';
import { LandingComponent } from './views/landing/landing.component';
import { FormRegisterComponent } from './components/form-register/form-register.component';
import { FormLoginComponent } from './components/form-login/form-login.component';
import { ContactoComponent } from './components/contacto/contacto.component';
import { HomeComponent } from './views/home/home.component';
import { HeaderHomeComponent } from './components/header-home/header-home.component';
import { ProfileComponent } from './components/profile/profile.component';
import { ClientFormComponent } from './components/client-form/client-form.component';
import { LogroComponent } from './components/logro/logro.component';
import { AuthGuard } from './router/auth.guard';
import { UpdateImgComponent } from './views/update-img/update-img.component';
import { UpdateProfileComponent } from './views/update-profile/update-profile.component';
import { BlogComponent } from './views/blog/blog.component';
import { SelectDropDownModule } from 'ngx-select-dropdown'
import { LoginGuard } from './router/login.guard';
import { TransformadorEnumPipe } from './transformador-enum.pipe';

const routes:Routes = [
  {path: '', component: LandingComponent},
  {path: 'login', component: LoginComponent, canActivate: [LoginGuard]},
  {path: 'register', component: RegisterComponent, canActivate: [LoginGuard]},
  {path: 'contacto', component: ContactoComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'blog', component: BlogComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    HeaderComponent,
    BienvenidaComponent,
    InfoComponent,
    FooterComponent,
    RegisterComponent,
    LoginComponent,
    LandingComponent,
    FormRegisterComponent,
    FormLoginComponent,
    ContactoComponent,
    HomeComponent,
    HeaderHomeComponent,
    ProfileComponent,
    ClientFormComponent,
    LogroComponent,
    UpdateImgComponent,
    UpdateProfileComponent,
    BlogComponent,
    TransformadorEnumPipe
  ],
  imports: [
    HttpClientModule,
    FormsModule, // Agrega FormsModule a la lista de importaciones
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    SelectDropDownModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
