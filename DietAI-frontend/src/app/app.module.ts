import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';

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

const routes:Routes = [
  {path: '', component: LandingComponent},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  {path: 'contacto', component: ContactoComponent}

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
    ContactoComponent
  ],
  imports: [
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
