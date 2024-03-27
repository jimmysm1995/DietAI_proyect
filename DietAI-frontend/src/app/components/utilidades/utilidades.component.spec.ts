import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UtilidadesComponent } from './utilidades.component';

describe('UtilidadesComponent', () => {
  let component: UtilidadesComponent;
  let fixture: ComponentFixture<UtilidadesComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UtilidadesComponent]
    });
    fixture = TestBed.createComponent(UtilidadesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
