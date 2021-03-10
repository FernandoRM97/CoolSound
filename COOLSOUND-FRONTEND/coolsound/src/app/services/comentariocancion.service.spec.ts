import { TestBed } from '@angular/core/testing';

import { ComentariocancionService } from './comentariocancion.service';

describe('ComentariocancionService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: ComentariocancionService = TestBed.get(ComentariocancionService);
    expect(service).toBeTruthy();
  });
});
