import { TestBed } from '@angular/core/testing';

import { MealTimeService } from './meal-time.service';

describe('MealTimeService', () => {
  let service: MealTimeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MealTimeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
