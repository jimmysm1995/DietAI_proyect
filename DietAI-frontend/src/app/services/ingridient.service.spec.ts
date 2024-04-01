import { TestBed } from '@angular/core/testing';

import { IngridientService } from './ingridient.service';

describe('IngridientService', () => {
  let service: IngridientService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(IngridientService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
