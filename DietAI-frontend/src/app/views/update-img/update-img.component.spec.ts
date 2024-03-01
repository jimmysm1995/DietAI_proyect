import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateImgComponent } from './update-img.component';

describe('UpdateImgComponent', () => {
  let component: UpdateImgComponent;
  let fixture: ComponentFixture<UpdateImgComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [UpdateImgComponent]
    });
    fixture = TestBed.createComponent(UpdateImgComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
