import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {
    @Output() aceptarFormulario = new EventEmitter();

    aceptar(){
        this.aceptarFormulario.emit();
    }
}
