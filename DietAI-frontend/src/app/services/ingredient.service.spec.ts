import { TestBed } from '@angular/core/testing';

import { IngredientService } from './ingredient.service';

describe('IngridientService', () => {
  let service: IngredientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IngredientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
