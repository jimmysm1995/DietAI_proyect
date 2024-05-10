import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule, Routes } from '@angular/router';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

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
import { EntradasBlogComponent } from './components/entradas-blog/entradas-blog.component';
import { UtilidadesComponent } from './components/utilidades/utilidades.component';
import { EntrenameintoComponent } from './components/entrenameinto/entrenameinto.component';
import { DietComponent } from './components/diet/diet.component';
import { RecipeComponent } from './components/recipe/recipe.component';
import { AdminComponent } from './views/admin/admin.component';
import { IngredientComponent } from './components/ingredient/ingredient.component';
import { RecipeAdminComponent } from './components/recipe-admin/recipe-admin.component';
import { ExerciseComponent } from './components/exercise/exercise.component';
import { DietAdminComponent } from './components/diet-admin/diet-admin.component';
import { TrainingComponent } from './components/training/training.component';
import { FilterTrainingPipe } from './components/entrenameinto/entrenamientoPipe';
import { ShoppingListComponent } from './components/shopping-list/shopping-list.component';

const routes:Routes = [
  {path: '', component: LandingComponent},
  {path: 'login', component: LoginComponent, canActivate: [LoginGuard]},
  {path: 'register', component: RegisterComponent, canActivate: [LoginGuard]},
  {path: 'contacto', component: ContactoComponent},
  {path: 'home', component: HomeComponent, canActivate: [AuthGuard]},
  {path: 'blog', component: BlogComponent},
  {path: 'admin', component: AdminComponent, canActivate: [AuthGuard]}
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
    TransformadorEnumPipe,
    EntradasBlogComponent,
    UtilidadesComponent,
    EntrenameintoComponent,
    DietComponent,
    RecipeComponent,
    AdminComponent,
    IngredientComponent,
    RecipeAdminComponent,
    ExerciseComponent,
    DietAdminComponent,
    ExerciseComponent,
    TrainingComponent,
    FilterTrainingPipe,
    ShoppingListComponent
  ],
  imports: [
    HttpClientModule,
    FormsModule, // Agrega FormsModule a la lista de importaciones
    RouterModule.forRoot(routes),
    BrowserModule,
    AppRoutingModule,
    SelectDropDownModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
