import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  ngOnInit() {
    this.muestra();
  }
  muestra(){
    console.log("tamaño ancho: " + window.innerWidth);
    console.log("tamaño altura: " + window.innerHeight);
  }

}
