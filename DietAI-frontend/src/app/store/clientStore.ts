import { Injectable } from '@angular/core';
import { Client } from '../models/Client';

//actúa como una clase singleton para poder utilizarlo en todos los componentes
@Injectable({
    // con porvidedIn controlamos quién tiene acceso a esta clase, al ser "root" se puede inyectar en cualquier lugar de la aplicación
    providedIn: 'root',
})
export class ClientStore {
    //se crea un nuevo store para el usuario para poder utilizarlo en todos los componentes
    client: Client = new Client();


    //*PATRÓN OBSERVADOR CON PATRON DE DISEÑO PUBLISHER-SUBSCRIBER */ 

    //array de funciones que se ejecutan cuando cambia el estado del store de usuario para poder notificar a todos los componentes que estan suscritos a este store de usuario 
    private subscribers: ((estado: Client) => void)[] = [];

    updateClient(client: Client) {
        this.client = client;
        this.notifySubscribers();
    }

    subscribeClient(subscriber: (estado: Client) => void) {
        this.subscribers.push(subscriber);
    }

    private notifySubscribers() {
        this.subscribers.forEach((subscriber) => subscriber(this.client));
    }
}
