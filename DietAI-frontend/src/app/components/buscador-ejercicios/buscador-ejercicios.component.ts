import { Component } from '@angular/core';
import { Exercise, Muscle } from 'src/app/models/Exercise';
import { ExerciseService } from 'src/app/services/exercise.service';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';

@Component({
    selector: 'app-buscador-ejercicios',
    templateUrl: './buscador-ejercicios.component.html',
    styleUrls: ['./buscador-ejercicios.component.css'],
})
export class BuscadorEjerciciosComponent {
limpiarLista() {
   this.filteredExercises = [];
}

    @ViewChild('muscleForm') muscleForm!: NgForm;
    constructor(
      private exerciseService: ExerciseService,
    ) {}

    public selectedExercise: Exercise = new Exercise();
    public exercises: Exercise[] = [];
    public muscle: Muscle[] = [];
    public filterMuscle: Muscle[] = [];
    public filteredExercises: Exercise[] = [];

    ngOnInit(): void {
        this.findMuscle();
        this.exerciseService.getAllExercises().then((exercises: Exercise[]) => {
            this.exercises = exercises;
        });
    }

    findMuscle() {
        this.exerciseService.getMuscles().then((muscles: Muscle[]) => {
            this.muscle = muscles;
        });
    }

    async buscarEjercicios() {
        this.filteredExercises = [];
        for (const exercise of this.exercises) {
            // Obtener los músculos del ejercicio
            const muscles = await this.exerciseService.findAllMusclesInExercise(
                exercise.idExercise
            );
            // Verificar si el ejercicio contiene todos los músculos del filtro
            const containsAllMuscles = this.filterMuscle.every((filterMuscle) =>
                muscles.some(
                    (muscle) => muscle.idMuscle === filterMuscle.idMuscle
                )
            );
            // Si el ejercicio contiene todos los músculos del filtro, agregarlo al array de ejercicios filtrados
            if (containsAllMuscles) {
                this.filteredExercises.push(exercise);
            }
        }
    }

    
    mostrarEjercicio(ejercicio: Exercise) {
        this.selectedExercise = ejercicio
    }

}
