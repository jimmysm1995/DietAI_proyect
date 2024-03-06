import { Injectable } from '@angular/core';
import axios from 'axios';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class ImagenProfileService {

  private baseUrl: string = environment.apiUrl+'/api/imagenProfiles';


  getAllImageUrls(): Promise<string[]> {
    return axios.get<string[]>(`${this.baseUrl}/urls`).then((response) => response.data);
  }
}
