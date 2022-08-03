import { TestBed } from '@angular/core/testing';

import { BillserviceService } from './billservice.service';

describe('BillserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: BillserviceService = TestBed.get(BillserviceService);
    expect(service).toBeTruthy();
  });
});
