import { TestBed } from '@angular/core/testing';

import { AuthenticationService } from './authintication.service';

describe('AuthinticationService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: AuthenticationService = TestBed.get(AuthenticationService);
    expect(service).toBeTruthy();
  });
});
