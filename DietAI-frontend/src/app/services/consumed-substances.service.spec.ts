import { TestBed } from '@angular/core/testing';

import { ConsumedSubstancesService } from './consumed-substances.service';

describe('ConsumedSubstancesService', () => {
  let service: ConsumedSubstancesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ConsumedSubstancesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
