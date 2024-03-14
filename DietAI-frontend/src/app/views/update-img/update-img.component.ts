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
        public userStore: UserStore,
        private imagenProfileService: ImagenProfileService,
        private userService: UserService
    ) {
        this.loadUrls();
    }
    // getImage() {
    //     ;
    //     this.userService.getUserByUsername(username).then((user: User) => {
    //         this.userService
    //             .updateUser(user)
    //             .then((updatedUser: User) => {
    //                 // Actualiza el usuario en el userStore con los datos actualizados
    //                 this.userStore.user.img = updatedUser.img;
    //             })
    //             .catch((error) => {
    //                 console.error('Error updating user:', error);
    //             });
    //     });
    // }

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
        let prepUrl = this.userStore.user.img;
        this.userStore.user.img = url;
            this.userService
                .updateUser(this.userStore.user)
                .then((updatedUser: User) => {
                    // Actualiza el usuario en el userStore con los datos actualizados
                    this.userStore.user.img = updatedUser.img;
                })
                .catch((error) => {
                    console.error('Error updating user:', error);
                    this.userStore.user.img = prepUrl;
                });
    }
}
