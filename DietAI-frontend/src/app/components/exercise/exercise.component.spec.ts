import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ExerciseComponent } from './exercise.component';

describe('EjerciciosComponent', () => {
  let component: ExerciseComponent;
  let fixture: ComponentFixture<ExerciseComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ExerciseComponent]
    });
    fixture = TestBed.createComponent(ExerciseComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
