import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Course} from "../model/course";
import {delay, first} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  private readonly API = '/assets/courses.json';
  constructor(private httpClient: HttpClient) { }

  list() {
    return this.httpClient.get<Course[]>(this.API).pipe(
      first(),
      delay(200),
    );
  }
}
