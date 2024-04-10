import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DietAdminComponent } from './diet-admin.component';

describe('DietAdminComponent', () => {
  let component: DietAdminComponent;
  let fixture: ComponentFixture<DietAdminComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DietAdminComponent]
    });
    fixture = TestBed.createComponent(DietAdminComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
