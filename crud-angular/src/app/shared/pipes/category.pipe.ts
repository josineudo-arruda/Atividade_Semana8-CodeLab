import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'category'
})
export class CategoryPipe implements PipeTransform {

  transform(value: string): string {
    switch (value) {
      case 'Country': return 'home';
      case 'Pop': return 'computer'
    }
  return 'code';
  }
}
