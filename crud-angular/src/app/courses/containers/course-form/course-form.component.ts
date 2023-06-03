import { Component } from '@angular/core';

import {FormBuilder, FormGroup, NonNullableFormBuilder} from "@angular/forms";
import {CoursesService} from "../../services/courses.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {Location} from "@angular/common";

@Component({
  selector: 'app-course-form',
  templateUrl: './course-form.component.html',
  styleUrls: ['./course-form.component.css']
})
export class CourseFormComponent{

  form = this.formBuilder.group({
    name: [''],
    category: [''],
  })
  constructor(
    private formBuilder: NonNullableFormBuilder,
    private service: CoursesService,
    private snackBar: MatSnackBar,
    private location: Location) {
  }

  onSubmit() {
    this.service.save(this.form.value)
      .subscribe(result => this.onSuccess(), error => {
        this.onError()
      })
  }

  onCancel() {this.location.back()}

  private onSuccess() {
    this.snackBar.open('Curso salvo com sucesso!', '', {duration: 5000})
    this.onCancel()
  }

  private onError() {
    this.snackBar.open('Erro ao salvar curso.', '', {duration: 5000})
  }
}
