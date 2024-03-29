import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DietComponent } from './diet.component';

describe('DietComponent', () => {
  let component: DietComponent;
  let fixture: ComponentFixture<DietComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DietComponent]
    });
    fixture = TestBed.createComponent(DietComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
