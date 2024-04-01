import { TestBed } from '@angular/core/testing';

import { RecipeAdminService } from './recipe-admin.service';

describe('RecipeAdminService', () => {
  let service: RecipeAdminService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecipeAdminService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
