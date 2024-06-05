import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EntradaBlogComponent } from './entrada-blog.component';

describe('EntradasBlogComponent', () => {
  let component: EntradaBlogComponent;
  let fixture: ComponentFixture<EntradaBlogComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [EntradaBlogComponent]
    });
    fixture = TestBed.createComponent(EntradaBlogComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
