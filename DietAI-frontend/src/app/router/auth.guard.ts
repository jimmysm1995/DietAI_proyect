import { Injectable, inject } from '@angular/core';
import {
    CanActivateFn,
    Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot,
} from '@angular/router';
import { UserStore } from '../store/userStore';
import { UserService } from '../services/user.service';
import { Client } from '../models/Client';
import { User } from '../models/User';

@Injectable({
    providedIn: 'root',
})
class PermissionsService {
    constructor(
        private router: Router,
        private userStore: UserStore,
        private userService: UserService) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Promise<boolean> | boolean {
        if (localStorage.getItem('sesion')) {
            if(!this.userStore.user.username){
                this.userStore.user.username = localStorage.getItem('username') + '';
                //cuando esté disponible el echoService hay que cambiar la línea de abajo para que llame a ese servicio y no obtenga los datos de localStorage
                 
                return this.userService.getCurrentUser().then((user: User) => {
                    
                    this.userStore.user = user;
                    return true;
                }) 
            }
            return true
        }
        this.router.navigate(['/login']);
        return false;
    }
}

export const AuthGuard: CanActivateFn = (
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
): Promise <boolean> | boolean => {
    return inject(PermissionsService).canActivate(next, state);
};
