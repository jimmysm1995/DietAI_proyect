import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';


@Injectable({
  providedIn: 'root'
})
export class QuotesService {

  private baseUrl: string = environment.apiUrl+'/api/quotes';

  getRandomQuote(): Promise<string> {
    return axios.get(this.baseUrl).then((response) => response.data);
  }


}
