import { TestBed, inject } from '@angular/core/testing';

import { RawmaterialService } from './rawmaterial.service';

describe('RawmaterialService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RawmaterialService]
    });
  });

  it('should be created', inject([RawmaterialService], (service: RawmaterialService) => {
    expect(service).toBeTruthy();
  }));
});
