import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { User } from '../models/User';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  
  private baseUrl: string = 'http://localhost:8080/api/users';

  constructor(private http: HttpClient) { }

  getUsers(): Observable<User[]> {
    return this.http.get<any[]>(this.baseUrl);
  }

  getUser(id: number): Observable<User> {
    return this.http.get<any>(`${this.baseUrl}/${id}`);
  }

  createUser(user: any): Observable<User> {
    return this.http.post<any>(this.baseUrl, user);
  }

  updateUser(user: any): Observable<User> {
    return this.http.put<any>(`${this.baseUrl}/${user.idUser}`, user);
  }

  deleteUser(id: number): Observable<User> {
    return this.http.delete<any>(`${this.baseUrl}/${id}`);
  }

  loginUser(user: any): Observable<User> {
    return this.http.post<any>(`${this.baseUrl}/login`, user);
  }

  registerUser(userData: any): Observable<User> {
    return this.http.post<any>('http://localhost:8080/api/users/register', userData)
      .pipe(
        catchError((error) => {
          let errorMessage = 'Something bad happened; please try again later.';
          
          if (error.error instanceof ErrorEvent) {
            // Error del lado del cliente
            console.error('An error occurred:', error.error.message);
          } else if (error.status === 200) {
            // Si el código de estado es 200, pero el cuerpo de la respuesta es un objeto, se debe manejar como un error del lado del servidor
            console.error(`Backend returned code ${error.status}, but response body could not be parsed.`);
          } else {
            // Error del lado del servidor con cuerpo en formato JSON
            console.error(`Backend returned code ${error.status}, body was:`, error.error);
            errorMessage = error.error; // Puedes ajustar esto según el formato real del error devuelto por el backend
          }
          
          return throwError(errorMessage);
        })
      );
  }
}
