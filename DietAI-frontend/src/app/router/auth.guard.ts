import { Injectable, inject } from '@angular/core';
import {
    CanActivateFn,
    Router,
    ActivatedRouteSnapshot,
    RouterStateSnapshot,
} from '@angular/router';
import { UserStore } from '../store/userStore';

@Injectable({
    providedIn: 'root',
})
class PermissionsService {
    constructor(
        private router: Router,
        private userStore: UserStore) {}

    canActivate(
        next: ActivatedRouteSnapshot,
        state: RouterStateSnapshot
    ): boolean {
        if (localStorage.getItem('sesion')) {
            if(!this.userStore.user.username){
                this.userStore.user.username = localStorage.getItem('username') + '';
            }
            return true;
        }
        this.router.navigate(['/login']);
        return false;
    }
}

export const AuthGuard: CanActivateFn = (
    next: ActivatedRouteSnapshot,
    state: RouterStateSnapshot
): boolean => {
    return inject(PermissionsService).canActivate(next, state);
};
