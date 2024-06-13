import { Component, EventEmitter, Output, ViewChild } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ClientService } from '../../services/client.service';
import { Client } from 'src/app/models/Client';
import { UserStore } from 'src/app/store/userStore';
import { InjuryService } from 'src/app/services/injury.service';
import { AllergyService } from 'src/app/services/allergy.service';
import { Allergy } from 'src/app/models/Allergy';
import { Injury } from 'src/app/models/Injury';
import { JobTypeService } from '../../services/job-type.service';
import { PreviusLevel } from 'src/app/models/PreviusLevel';
import { PreviusLevelService } from 'src/app/services/previus-level.service';
import { ConsumedSubstancesService } from '../../services/consumed-substances.service';
import { ConsumedSubstances } from 'src/app/models/ConsumedSubstances';
import { Gender } from '../../models/Gender';
import { GenderService } from '../../services/gender-controller.service';
import { Goal } from 'src/app/models/Goal';
import { GoalService } from '../../services/goal.service';
import { ClientStore } from 'src/app/store/clientStore';
import { ExerciseService } from 'src/app/services/exercise.service';

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
    public typeTraining: string[] = [];

    constructor(
        private clientService: ClientService,
        private userStore: UserStore,
        private injuryService: InjuryService,
        private allergyService: AllergyService,
        private jobTypeService: JobTypeService,
        private previusLevelService: PreviusLevelService,
        private consumedSubstancesService: ConsumedSubstancesService,
        private genderService: GenderService,
        private goalService: GoalService,
        private clientStore: ClientStore,
        private exerciseService: ExerciseService
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
        this.exerciseService.getTypeTraining().then((typeTraining) => {
            this.typeTraining = typeTraining;
        });

        this.clientService.getCurrentClient().then((client) => {
            
            this.clientForm.setValue({'weight': client.weight});
        })
    }

    aceptar() {
        this.clientStore.saveClient(this.clientStore.client);
        this.aceptarFormulario.emit();
    }

    async registrarCliente(clientData: Client) {
        console.log(clientData);
        clientData.user = this.userStore.user;
        //Para asignar client a clientStore espera a que la petición responda.
        try {
            this.clientStore.client = await this.clientService.registerClient(
                clientData
            );
            await this.clientService.asignarDieta(
                this.clientStore.client.idClient ?? 0
            );
            this.clientStore.client =
                await this.clientService.asignarEntrenamiento(
                    this.clientStore.client.idClient ?? 0
                );
            this.aceptar();
        } catch (error:any) {
            this.errorMessage = error.message;
       }
        // this.aceptar();
    }

        clearErrorMessage() {
        this.errorMessage = '';
    }
}
