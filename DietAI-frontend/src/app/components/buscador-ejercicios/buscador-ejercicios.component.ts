import { Component } from '@angular/core';
import { Exercise, Muscle } from 'src/app/models/Exercise';
import { ExerciseService } from 'src/app/services/exercise.service';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { MuscleInExercise, TypeTraining } from '../../models/Exercise';
import { TrainingService } from 'src/app/services/training.service';
import { Training, TrainingResponse } from 'src/app/models/Training';
import { FilterTrainingPipe } from '../entrenameinto/entrenamientoPipe';
import { ClientStore } from 'src/app/store/clientStore';
import { Client } from '../../models/Client';
import { ClientService } from 'src/app/services/client.service';

@Component({
    selector: 'app-buscador-ejercicios',
    templateUrl: './buscador-ejercicios.component.html',
    styleUrls: ['./buscador-ejercicios.component.css'],
})
export class BuscadorEjerciciosComponent {
    @ViewChild('muscleForm') muscleForm!: NgForm;

    constructor(
      private exerciseService: ExerciseService,
    ) {}

    public exercise: Exercise = new Exercise();
    public exercises: Exercise[] = [];
    public muscle: Muscle[] = [];
    public typeTraining: string[] = [];
    public selectedExerciseId: number = 0;

    ngOnInit(): void {
        this.findMuscle();
        this.findTypeTraining();
        this.exerciseService.getAllExercises().then((exercises: Exercise[]) => {
            this.exercises = exercises;
        });
    }

    findMuscle() {
        this.exerciseService.getMuscles().then((muscles: Muscle[]) => {
            this.muscle = muscles;
        });
    }

    findTypeTraining() {
        this.exerciseService
            .getTypeTraining()
            .then((typeTraining: string[]) => {
                this.typeTraining = typeTraining;
            });
    }

    // mostrarEjercicios(){
    //   this.exerciseService.getAllExercises(this.exercise.muscle).then((exercises: Exercise[]) => {
    //     this.exercises = exercises;
    //   })
    // }
}
