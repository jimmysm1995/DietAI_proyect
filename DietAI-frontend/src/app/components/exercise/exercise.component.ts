import { Component } from '@angular/core';
import { Exercise, Muscle } from 'src/app/models/Exercise';
import { ExerciseService } from 'src/app/services/exercise.service';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { MuscleInExercise, TypeTraining } from '../../models/Exercise';
import { ApiError } from 'src/app/models/ApiError';

@Component({
    selector: 'app-exercise',
    templateUrl: './exercise.component.html',
    styleUrls: ['./exercise.component.css'],
})
export class ExerciseComponent {
  // Esta función se llama cuando se hace clic en el botón de cierre
    errorMessage: string = '';
    @ViewChild('muscleForm') muscleForm!: NgForm;

    constructor(private exerciseService: ExerciseService) {}

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
    saveExercise() {
        if (this.exercise.typeTraining === "") {
            this.errorMessage = 'Debe seleccionar un tipo de Entrenamiento';
        } else if (this.exercise.muscle?.length === 0) {
            this.errorMessage = 'Debe seleccionar al menos un musculo';
        } else {
            this.exerciseService.postExercise(this.exercise).then((exercise) => {
                this.exercise = new Exercise();
                this.ngOnInit();
            }).catch((error: ApiError) => {
                this.errorMessage = error.message;
            });
        }
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

    deleteExercise() {
        this.exerciseService
            .deleteExercixe(this.selectedExerciseId)
            .then(() => {
                this.selectedExerciseId = 0;
                this.ngOnInit();
            });
    }

    clearErrorMessage() {
        this.errorMessage = "";
    }
}
