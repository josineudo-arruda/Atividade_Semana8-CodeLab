import { TestBed } from '@angular/core/testing';
import { ResolveFn } from '@angular/router';
import {CoursesService} from "../../services/courses.service";


describe('courseResolver', () => {
  const executeResolver: ResolveFn<boolean> = (...resolverParameters) =>
    TestBed.runInInjectionContext(() => CoursesService(...resolverParameters));

  beforeEach(() => {
    TestBed.configureTestingModule({});
  });

  it('should be created', () => {
    expect(executeResolver).toBeTruthy();
  });
});
