import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogroComponent } from './logro.component';

describe('LogroComponent', () => {
  let component: LogroComponent;
  let fixture: ComponentFixture<LogroComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [LogroComponent]
    });
    fixture = TestBed.createComponent(LogroComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
