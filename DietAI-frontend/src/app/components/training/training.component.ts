import { Component } from '@angular/core';
import { Training } from 'src/app/models/Training';
import { TrainingService } from 'src/app/services/training.service';
import { Exercise } from '../../models/Exercise';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { ExerciseService } from 'src/app/services/exercise.service';
import { ExerciseInTraining } from 'src/app/models/ExercisesInTraining';
import { TrainingWithExercisesRequest } from 'src/app/models/TrainingWithExercisesRequest';

@Component({
  selector: 'app-training',
  templateUrl: './training.component.html',
  styleUrls: ['./training.component.css']
})
export class TrainingComponent {
  @ViewChild('trainingExerciseForm') trainingExerciseForm!: NgForm;

  constructor(private trainingService: TrainingService,
    private exerciseService: ExerciseService
  ) { }

  public training: Training = new Training();
  public exercises: Exercise[] = [];
  public exercisesInTraining: ExerciseInTraining[] = [];
  public exerciseInTraining: ExerciseInTraining = new ExerciseInTraining();
  public typeTraining: string[] = [];
  public trainingWithExerciseRequest: TrainingWithExercisesRequest = new TrainingWithExercisesRequest();
  public trainings: Training[] = [];
  public selectedTrainingId: number = 0;

  ngOnInit(): void {
    this.exerciseService.getAllExercises().then((exercises) => {
      this.exercises = exercises;
    });
    this.trainingService.getAllTrainings().then((trainings) => {
      this.trainings = trainings;
    })
    this.findTypeTraining();
  }

  saveTraining() {
    this.trainingWithExerciseRequest.training = this.training;
    this.trainingWithExerciseRequest.exercisesInTraining = this.exercisesInTraining;
    this.trainingService.postTraining(this.trainingWithExerciseRequest).then((newTraining) => {
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
    this.exerciseService.getTypeTraining().then((typeTraining: string[]) => {
      this.typeTraining = typeTraining
    })
  }

  deleteTraining() {
    this.trainingService.deleteTraining(this.selectedTrainingId).then(() => {
      this.selectedTrainingId = 0;
      this.ngOnInit();
    })
    }

  addExercise() {
      if (this.exerciseInTraining.exercise.idExercise != 0) {
        const existingIndex = this.exercisesInTraining.findIndex(exercise => 
          exercise.orderWeek === this.exerciseInTraining.orderWeek &&
          exercise.orderDay === this.exerciseInTraining.orderDay
        );
        if (existingIndex !== -1) {
          this.exercisesInTraining[existingIndex] = this.exerciseInTraining;
        } else {
            this.exercisesInTraining.push(this.exerciseInTraining);
        }
        this.exerciseInTraining = new ExerciseInTraining();
      }
      this.exercisesInTraining.sort((a, b) => (a.orderWeek - b.orderWeek));
      this.exercisesInTraining.sort((a, b) => (a.orderDay - b.orderDay));
  }
}
