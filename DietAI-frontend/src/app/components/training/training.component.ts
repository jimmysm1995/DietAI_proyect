import { Component } from '@angular/core';
import { Training } from 'src/app/models/Training';
import { TrainingService } from 'src/app/services/training.service';
import { TrainingExercise } from '../../models/Exercise';
import { Exercise } from '../../models/Exercise';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { ExerciseService } from 'src/app/services/exercise.service';

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
  public exerciseInTraining: Exercise[] = [];
  public typeTraining: string[] = [];

  ngOnInit(): void {
    this.trainingService.getAllExercises().then((exercises) => {
      this.exercises = exercises;
    });
    this.findTypeTraining();
  }

  saveTraining() {
    this.training.trainingExercises = [];
    this.trainingService.postTraining(this.training);
  }

  limpiarLista() {
    this.exerciseInTraining = [];
  }

  findTypeTraining() {
    this.exerciseService.getTypeTraining().then((typeTraining: string[]) => {
      this.typeTraining = typeTraining
    })
  }

  addExercise() {
    this.exerciseInTraining.push(this.trainingExerciseForm.value.exercise);
    this.trainingExerciseForm.reset();
  }
}
