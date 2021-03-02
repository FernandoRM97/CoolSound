import { TestBed } from '@angular/core/testing';

import { HiloService } from './hilo.service';

describe('HiloService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: HiloService = TestBed.get(HiloService);
    expect(service).toBeTruthy();
  });
});
