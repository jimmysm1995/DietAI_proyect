import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'transformadorEnum'
})
export class TransformadorEnumPipe implements PipeTransform {

  transform(value: any): string {

    if (!value) return value;

    return value.toLowerCase().replace(/_/g, ' ');
  }
}
