import { Component } from '@angular/core';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { User } from 'src/app/models/User';
import { UserService } from '../../services/user.service';


@Component({
  selector: 'app-form-register',
  templateUrl: './form-register.component.html',
  styleUrls: ['./form-register.component.css']
})
export class FormRegisterComponent {

  constructor(private userService: UserService) { }

  Users?: User[]

  registrarUsuario(userData: any): void {
    this.userService.registerUser(userData)
    .subscribe(
      (response: any) => {
        console.log('Response from backend:', response);
        // Procesar la respuesta aquí
      },
      error => {
        console.error('Error registering user:', error);
        // Manejar errores aquí
      }
    );
  }
  

}
