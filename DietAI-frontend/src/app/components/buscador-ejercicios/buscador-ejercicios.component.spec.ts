import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BuscadorEjerciciosComponent } from './buscador-ejercicios.component';

describe('BuscadorEjerciciosComponent', () => {
  let component: BuscadorEjerciciosComponent;
  let fixture: ComponentFixture<BuscadorEjerciciosComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BuscadorEjerciciosComponent]
    });
    fixture = TestBed.createComponent(BuscadorEjerciciosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
