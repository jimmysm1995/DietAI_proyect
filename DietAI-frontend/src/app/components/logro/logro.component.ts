import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-logro',
  templateUrl: './logro.component.html',
  styleUrls: ['./logro.component.css']
})

export class LogroComponent {
  @Input() nombre:string = "";
  @Input() numero:number = 0;
}
