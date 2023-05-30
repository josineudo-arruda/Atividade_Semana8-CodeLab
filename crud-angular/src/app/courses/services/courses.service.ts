import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class CoursesService {

  constructor(private httpClient: HttpClient) { }

  list() {
    return [
      {_id: '1', name: 'Taylor Swift', category: 'Country'}
    ];
  }
}
