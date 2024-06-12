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
import { RoleStore } from '../store/roleStore';

@Injectable({
    providedIn: 'root',
})
class AdminGuardService {
    constructor(
        private router: Router,
        private userStore: UserStore,
        private userService: UserService,
        private clientService: ClientService,
        private clientStore: ClientStore,
        private roleStore: RoleStore
    ) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): Promise<boolean> | boolean {
        // que existe la sesión y que esta pertenece a un admin para que pueda acceder
        if (localStorage.getItem('sesion') && this.roleStore.getRole() === 'ADMIN') {
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
        // al no cumplir primeras dos condiciones no deja acceder
        this.router.navigate(['/home']);
        return false;
    }
}

export const AdminGuard: CanActivateFn = (
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
): Promise <boolean> | boolean => {
    return inject(AdminGuardService).canActivate(next, state);
};
