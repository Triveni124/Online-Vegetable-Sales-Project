import { TestBed } from '@angular/core/testing';

import { VegetableserviceService } from './vegetableservice.service';

describe('VegetableserviceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: VegetableserviceService = TestBed.get(VegetableserviceService);
    expect(service).toBeTruthy();
  });
});
