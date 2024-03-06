import { Component } from '@angular/core';
import { UserStore } from 'src/app/store/userStore';
import { ImagenProfileService } from '../../services/imagen-profile.service';
import { UserService } from '../../services/user.service';
import { User } from 'src/app/models/User';

@Component({
    selector: 'app-update-img',
    templateUrl: './update-img.component.html',
    styleUrls: ['./update-img.component.css'],
})
export class UpdateImgComponent {
    public urls: string[] = [];

    constructor(
        private userStore: UserStore,
        private imagenProfileService: ImagenProfileService,
        private userService: UserService
    ) {
        this.loadUrls();
        this.getImage();
    }
    getImage() {
        var username = this.userStore.user.username;
        this.userService.getUserByUsername(username).then((user: User) => {
            this.userService
                .updateUser(user)
                .then((updatedUser: User) => {
                    console.log('User updated successfully:', user);
                    // Actualiza el usuario en el userStore con los datos actualizados
                    this.userStore.user.img = updatedUser.img;
                })
                .catch((error) => {
                    console.error('Error updating user:', error);
                });
        });
    }

    loadUrls(): Promise<void> {
        return this.imagenProfileService
            .getAllImageUrls()
            .then((urls) => {
                this.urls = urls;
            })
            .catch((error) => {
                console.error('Error fetching image URLs:', error);
            });
    }

    updateImg(url: string) {
        var username = this.userStore.user.username;
        this.userService.getUserByUsername(username).then((user: User) => {
            user.img = url;
            this.userService
                .updateUser(user)
                .then((updatedUser: User) => {
                    console.log('User updated successfully:', user);
                    // Actualiza el usuario en el userStore con los datos actualizados
                    this.userStore.user.img = updatedUser.img;
                })
                .catch((error) => {
                    console.error('Error updating user:', error);
                });
        });
    }
}
