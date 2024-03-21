import { TestBed } from '@angular/core/testing';

import { PreviusLevelService } from './previus-level.service';

describe('PreviusLevelService', () => {
  let service: PreviusLevelService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(PreviusLevelService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
