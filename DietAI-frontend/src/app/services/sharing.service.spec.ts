import { TestBed } from '@angular/core/testing';

import { SharingService } from './sharing.service';

describe('EmailService', () => {
  let service: SharingService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SharingService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
