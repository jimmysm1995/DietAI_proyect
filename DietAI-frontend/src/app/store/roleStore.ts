import { Injectable } from '@angular/core';
import { Client } from '../models/Client';

//actúa como una clase singleton para poder utilizarlo en todos los componentes
@Injectable({
    // con porvidedIn controlamos quién tiene acceso a esta clase, al ser "root" se puede inyectar en cualquier lugar de la aplicación
    providedIn: 'root',
})
export class RoleStore {
    //se crea un nuevo store para el usuario para poder utilizarlo en todos los componentes
    saveRole(role:string) {
        localStorage.setItem('authorities', role);
    }

    getRole() {
        return localStorage.getItem('authorities');
    }

    deleteRole() {
        localStorage.removeItem('authorities');
    }
}
