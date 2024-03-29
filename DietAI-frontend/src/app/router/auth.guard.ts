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
import { ClientService } from '../services/client.service';
import { ClientStore } from '../store/clientStore';

@Injectable({
    providedIn: 'root',
})
class AuthGuardService {
    constructor(
        private router: Router,
        private userStore: UserStore,
        private userService: UserService,
        private clientService: ClientService,
        private clientStore: ClientStore ) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Promise<boolean> | boolean {
        if (localStorage.getItem('sesion')) {
            if(!this.userStore.user.username){
                return Promise.all([
                    this.userService.getCurrentUser(),this.clientService.getCurrentClient()
                ]).then(([user,client]) => {
                    this.userStore.user = user
                    this.clientStore.client = client
                    return true
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
    return inject(AuthGuardService).canActivate(next, state);
};
