import {ActivatedRouteSnapshot, Resolve, ResolveFn, RouterStateSnapshot} from '@angular/router';

import {Observable, of} from "rxjs";

import {Injectable} from "@angular/core";
import {Course} from "../../model/course";
import {CoursesService} from "../../services/courses.service";

@Injectable({
  providedIn: 'root'
})

export class CourseResolver implements Resolve<Course> {

  constructor(private service: CoursesService) {

  }

  resolve(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): Observable<Course> {
    if(route.params && route.params['id']) {
      return this.service.loadById(route.params['id'])
    }
    return of({_id: '', name: '', category: ''})
  }

}
