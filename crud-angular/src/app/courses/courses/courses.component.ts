import { Component } from '@angular/core';
import {Course} from "../model/course";
import {CoursesService} from "../services/courses.service";
import {catchError, Observable, of} from "rxjs";
import {MatDialog} from "@angular/material/dialog";
import {ErrorDialogComponent} from "../../shared/components/error-dialog/error-dialog.component";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent {
  courses$: Observable<Course[]>;
  displayedColumns = ['name', 'category', 'actions']

  // courseService: CoursesService;
  constructor(private courseService: CoursesService,
              public dialog: MatDialog,
              private router: Router,
              private route: ActivatedRoute) {
    //this.courses = [];
    // this.courseService = new CoursesService();
    this.courses$ = this.courseService.list()
      .pipe(
        catchError(error => {
          this.openError("Erro ao carregar álbuns.")
          return of([])
        })
      );
  }

  openError(errorMsg: string) {
    this.dialog.open(ErrorDialogComponent, {
      data: errorMsg
    });
  }

  onAdd() {
    this.router.navigate(['new'], {relativeTo: this.route})
  }

  ngOnInit(): void {

  }
}
