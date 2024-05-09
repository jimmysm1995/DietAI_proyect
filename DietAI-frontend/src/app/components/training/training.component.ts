import { Component } from '@angular/core';
import { Training } from 'src/app/models/Training';
import { TrainingService } from 'src/app/services/training.service';
import { Exercise } from '../../models/Exercise';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { ExerciseService } from 'src/app/services/exercise.service';
import { ExerciseInTraining } from 'src/app/models/ExercisesInTraining';
import { TrainingWithExercisesRequest } from 'src/app/models/TrainingWithExercisesRequest';
import { Muscle } from 'src/app/models/Muscles';

@Component({
    selector: 'app-training',
    templateUrl: './training.component.html',
    styleUrls: ['./training.component.css'],
})
export class TrainingComponent {
    @ViewChild('trainingExerciseForm') trainingExerciseForm!: NgForm;

    constructor(
        private trainingService: TrainingService,
        private exerciseService: ExerciseService
    ) {}

    public training: Training = new Training();
    public exercises: Exercise[] = [];
    public exercisesInTraining: ExerciseInTraining[] = [];
    public exerciseInTraining: ExerciseInTraining = new ExerciseInTraining();
    public typeTraining: string[] = [];
    public trainingWithExerciseRequest: TrainingWithExercisesRequest =
        new TrainingWithExercisesRequest();
    public trainings: Training[] = [];
    public selectedTrainingId: number = 0;
    public muscle: Muscle[] = [];
    public filterMuscle: Muscle[] = [];

    ngOnInit(): void {
        this.trainingService.getAllTrainings().then((trainings) => {
            this.trainings = trainings;
        });
        this.findTypeTraining();
        this.findMuscle();
    }

    saveTraining() {
        this.trainingWithExerciseRequest.training = this.training;
        this.trainingWithExerciseRequest.exercisesInTraining =
            this.exercisesInTraining;
        this.trainingService
            .postTraining(this.trainingWithExerciseRequest)
            .then((newTraining) => {
                this.training = new Training();
                this.exercisesInTraining = [];
                this.exerciseInTraining = new ExerciseInTraining();
            });
    }

    limpiarLista() {
        this.exercisesInTraining = [];
        this.exerciseInTraining = new ExerciseInTraining();
    }

    findTypeTraining() {
        this.exerciseService
            .getTypeTraining()
            .then((typeTraining: string[]) => {
                this.typeTraining = typeTraining;
            });
    }

    deleteTraining() {
        this.trainingService
            .deleteTraining(this.selectedTrainingId)
            .then(() => {
                this.selectedTrainingId = 0;
                this.ngOnInit();
            });
    }

    async onTrainingSelected() {
        switch (this.training.typeTraining) {
            case 'GIMNASIO':
                this.exercises = await this.filterByMuscle(
                    await this.exerciseService.getGymExercises(),
                    this.filterMuscle
                );
                break;
            case 'CASA':
                this.exercises = await this.filterByMuscle(
                    await this.exerciseService.getHomeExercises(),
                    this.filterMuscle
                );
                break;
            case 'AMBOS':
                this.exercises = await this.filterByMuscle(
                    await this.exerciseService.getAllExercises(),
                    this.filterMuscle
                );
                break;
            case '':
                this.exercises = [];
                break;
        }
    }
    async filterByMuscle(
        exercises: Exercise[],
        filterMuscles: Muscle[]
    ): Promise<Exercise[]> {
        const filteredExercises: Exercise[] = [];
        // Iterar sobre cada ejercicio
        for (const exercise of exercises) {
            // Obtener los músculos del ejercicio
            const muscles = await this.exerciseService.findAllMusclesInExercise(
                exercise.idExercise
            );

            // Verificar si el ejercicio contiene todos los músculos del filtro
            const containsAllMuscles = filterMuscles.every((filterMuscle) =>
                muscles.some(
                    (muscle) => muscle.idMuscle === filterMuscle.idMuscle
                )
            );
            // Si el ejercicio contiene todos los músculos del filtro, agregarlo al array de ejercicios filtrados
            if (containsAllMuscles) {
                filteredExercises.push(exercise);
            }
        }

        return filteredExercises;
    }

    addExercise() {
        if (this.exerciseInTraining.exercise.idExercise != 0) {
            const existingIndex = this.exercisesInTraining.findIndex(
                (exercise) =>
                    exercise.orderWeek === this.exerciseInTraining.orderWeek &&
                    exercise.orderDay === this.exerciseInTraining.orderDay
            );
            if (existingIndex !== -1) {
                this.exercisesInTraining[existingIndex] =
                    this.exerciseInTraining;
            } else {
                this.exercisesInTraining.push(this.exerciseInTraining);
            }
            this.exerciseInTraining = new ExerciseInTraining();
        }
        this.exercisesInTraining.sort((a, b) => a.orderDay - b.orderDay);
        this.exercisesInTraining.sort((a, b) => a.orderWeek - b.orderWeek);
    }

    findMuscle() {
        this.exerciseService.getMuscles().then((muscles: Muscle[]) => {
            this.muscle = muscles;
        });
    }
}
