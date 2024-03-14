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
class LoginGuardService {
    constructor(
        private router: Router,
    ){}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): boolean {
        //si existe sesión redirije a /home
        if (localStorage.getItem('sesion')) {
            this.router.navigate(['/home']);
            return false; //deniegas acceso a login
        }
        return true; // si no hay sesion iniciada permite entrar en login
    }
}

export const LoginGuard: CanActivateFn = (
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
): boolean => {
    return inject(LoginGuardService).canActivate(next, state);
};
