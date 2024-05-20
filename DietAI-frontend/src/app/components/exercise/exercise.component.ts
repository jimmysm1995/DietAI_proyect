import { Component } from '@angular/core';
import { Exercise, Muscle } from 'src/app/models/Exercise';
import { ExerciseService } from 'src/app/services/exercise.service';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { MuscleInExercise, TypeTraining } from '../../models/Exercise';

@Component({
    selector: 'app-exercise',
    templateUrl: './exercise.component.html',
    styleUrls: ['./exercise.component.css'],
})
export class ExerciseComponent {
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
        console.log(this.exercise);
        this.exerciseService.postExercise(this.exercise).then((exercise) => {});
        window.location.reload();
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
}
