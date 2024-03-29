import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntrenameintoComponent } from './entrenameinto.component';

describe('EntrenameintoComponent', () => {
  let component: EntrenameintoComponent;
  let fixture: ComponentFixture<EntrenameintoComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EntrenameintoComponent]
    });
    fixture = TestBed.createComponent(EntrenameintoComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
