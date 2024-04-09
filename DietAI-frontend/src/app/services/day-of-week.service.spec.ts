import { TestBed } from '@angular/core/testing';

import { DayOfWeekService } from './day-of-week.service';

describe('DayOfWeekService', () => {
  let service: DayOfWeekService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DayOfWeekService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
