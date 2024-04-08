import { Component } from '@angular/core';
import { Exercise, Muscle } from 'src/app/models/Exercise';
import { ExerciseService } from 'src/app/services/exercise.service';
import { NgForm } from '@angular/forms';
import { ViewChild } from '@angular/core';
import { MuscleInExercise } from '../../models/Exercise';

@Component({
  selector: 'app-exercise',
  templateUrl: './exercise.component.html',
  styleUrls: ['./exercise.component.css']
})
export class ExerciseComponent {
  @ViewChild('muscleForm') muscleForm!: NgForm;

  constructor(private exerciseService: ExerciseService){}

  public exercise: Exercise = new Exercise()
  public muscles: Muscle[] = []
  public muscleInExercise: MuscleInExercise[] = []

  ngOnInit(): void {
    this.findMuscle()
  }
  saveExercise() {
    this.exercise.muscles = this.muscleInExercise;
    this.exerciseService.postExercise(this.exercise).then(exercise=>{
    })
  }

  registraMuscleInExercise(muscleInExercise: MuscleInExercise) {
    this.muscleInExercise.push(muscleInExercise);
    this.muscleForm.reset();
  }

  findMuscle() {
    this.exerciseService.getMuscles().then((muscles: Muscle[]) => {
      this.muscles = muscles
    })
  }
}
