import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntradasBlogComponent } from './entradas-blog.component';

describe('EntradasBlogComponent', () => {
  let component: EntradasBlogComponent;
  let fixture: ComponentFixture<EntradasBlogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EntradasBlogComponent]
    });
    fixture = TestBed.createComponent(EntradasBlogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
