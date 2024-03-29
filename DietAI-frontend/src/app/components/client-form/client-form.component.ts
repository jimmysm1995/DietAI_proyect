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
import { JobTypeService } from '../../services/job-type.service';
import { JobType } from 'src/app/models/JobType';
import { PreviusLevel } from 'src/app/models/PreviusLevel';
import { PreviusLevelService } from 'src/app/services/previus-level.service';
import { ConsumedSubstancesService } from '../../services/consumed-substances.service';
import { ConsumedSubstances } from 'src/app/models/ConsumedSubstances';
import { Gender } from '../../models/Gender';
import { GenderService } from '../../services/gender-controller.service';
import { Goal } from 'src/app/models/Goal';
import { GoalService } from '../../services/goal.service';
import { AltaCliente } from 'src/app/models/AltaCliente';
import { ClientStore } from 'src/app/store/clientStore';

@Component({
    selector: 'app-client-form',
    templateUrl: './client-form.component.html',
    styleUrls: ['./client-form.component.css'],
})
export class ClientFormComponent {
    @ViewChild('clientForm') clientForm!: NgForm;
    errorMessage: string = '';
    idUser: string = '';
    @Output() aceptarFormulario = new EventEmitter();

    public allergies: Allergy[] = [];
    public injuries: Injury[] = [];
    public jobTypes: String[] = [];
    public previusLevel: PreviusLevel[] = [];
    public consumedSubstances: ConsumedSubstances[] = [];
    public gender: Gender[] = [];
    public goal: Goal[] = [];

    constructor(
        private clientService: ClientService,
        private userStore: UserStore,
        private router: Router,
        private injuryService: InjuryService,
        private allergyService: AllergyService,
        private jobTypeService: JobTypeService,
        private previusLevelService: PreviusLevelService,
        private consumedSubstancesService: ConsumedSubstancesService,
        private genderService: GenderService,
        private goalService: GoalService,
        private clientStore: ClientStore
    ) {}

    ngOnInit(): void {
        this.injuryService.getInjuries().then((injuries) => {
            this.injuries = injuries;
        });
        this.allergyService.getAllergies().then((allergies) => {
            this.allergies = allergies;
        });
        this.jobTypeService.getJobTypes().then((jobTypes) => {
            this.jobTypes = jobTypes;
        });
        this.previusLevelService.getPreviusLevels().then((previusLevel) => {
            this.previusLevel = previusLevel;
        });
        this.consumedSubstancesService
            .getConsumedSubstances()
            .then((consumedSubstances) => {
                this.consumedSubstances = consumedSubstances;
            });
        this.genderService.getGender().then((gender) => {
            this.gender = gender;
        });
        this.goalService.getGoal().then((goal) => {
            this.goal = goal;
        });
    }

    aceptar() {
        this.aceptarFormulario.emit();
    }

    registrarCliente(clientData: Client): void {
        console.log(clientData);
        clientData.user = this.userStore.user;
        this.clientService
            .registerClient(clientData)
            .then((client: Client) => {
                this.clientStore.client = client;
                this.aceptar();
            })
            .catch((error) => {
                this.errorMessage = error;
                // this.clientForm.resetForm();
            });
    }
}
