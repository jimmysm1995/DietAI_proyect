import { Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientService } from '../../services/client.service';
import { Router } from '@angular/router';
import { Client } from 'src/app/models/Client';
import { UserService } from 'src/app/services/user.service';
import { UserStore } from 'src/app/store/userStore';
import { InjuryService } from 'src/app/services/injury.service';
import { AllergyService } from 'src/app/services/allergy.service';
import { Allergy } from 'src/app/models/Allergy'; 
import { Injury } from 'src/app/models/Injury';

@Component({
  selector: 'app-client-form',
  templateUrl: './client-form.component.html',
  styleUrls: ['./client-form.component.css']
})
export class ClientFormComponent {
    @ViewChild('clientForm') clientForm!: NgForm;
    errorMessage: string = '';
    idUser: string = '';
    @Output() aceptarFormulario = new EventEmitter();

  public allergies: Allergy[] = [];
  public injuries: Injury[] = [];

    constructor(private ClientService: ClientService,
      private userStore: UserStore, 
      private router: Router,
      private injuryService: InjuryService,
      private allergyService: AllergyService) {}

    ngOnInit(): void {
      this.injuryService.getInjuries().then(injuries=>{
        this.injuries = injuries;
      });
      this.allergyService.getAllergies().then(allergies=>{
        this.allergies = allergies;
      });
    }

    aceptar(){
        this.aceptarFormulario.emit();
    }

    registrarCliente(clientData: Client): void {
        clientData.user = this.userStore.user;
        this.ClientService.registerClient(clientData).then((Client: Client) => {
        this.aceptar();
        }).catch((error) => {
          this.errorMessage = error;
          this.clientForm.resetForm();
        })
    }




}
