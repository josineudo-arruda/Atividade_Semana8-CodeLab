import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { SharedModule} from "../shared/shared.module";

import { CoursesRoutingModule } from './courses-routing.module';
import { CoursesComponent } from './containers/courses/courses.component';
import {AppMaterialModule} from "../shared/app-material/app-material.module";
import { CourseFormComponent } from './containers/course-form/course-form.component';
import {ReactiveFormsModule} from "@angular/forms";
import {CoursesListComponent} from "./components/courses-list/courses-list.component";

@NgModule({
  declarations: [
    CoursesComponent,
    CourseFormComponent,
    CoursesListComponent,
  ],
  imports: [
    CommonModule,
    CoursesRoutingModule,
    AppMaterialModule,
    SharedModule,
    ReactiveFormsModule,
  ]
})
export class CoursesModule { }
