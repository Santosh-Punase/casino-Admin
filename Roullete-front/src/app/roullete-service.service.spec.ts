import { TestBed, inject } from '@angular/core/testing';

import { RoulleteServiceService } from './roullete-service.service';

describe('RoulleteServiceService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [RoulleteServiceService]
    });
  });

  it('should be created', inject([RoulleteServiceService], (service: RoulleteServiceService) => {
    expect(service).toBeTruthy();
  }));
});
