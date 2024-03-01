import { Component } from '@angular/core';
import { UserStore } from 'src/app/store/userStore';

@Component({
  selector: 'app-update-img',
  templateUrl: './update-img.component.html',
  styleUrls: ['./update-img.component.css']
})

export class UpdateImgComponent {

  constructor(private userStore: UserStore) { }

  public urls: string[] = ['https://st2.depositphotos.com/1036149/5790/i/600/depositphotos_57900109-stock-photo-fun-frog-in-suit-with.jpg', 'https://st2.depositphotos.com/1036149/6187/i/450/depositphotos_61871905-stock-photo-strong-frog-3d.jpg', 'https://st.depositphotos.com/1036149/3669/i/600/depositphotos_36692137-stock-photo-strong-frog.jpg','https://st2.depositphotos.com/1036149/5790/i/600/depositphotos_57900109-stock-photo-fun-frog-in-suit-with.jpg', 'https://st2.depositphotos.com/1036149/6187/i/450/depositphotos_61871905-stock-photo-strong-frog-3d.jpg', 'https://st.depositphotos.com/1036149/3669/i/600/depositphotos_36692137-stock-photo-strong-frog.jpg'];

  updateImg(url: string) {
    var user = this.userStore.user;
    user.img = url;
    this.userStore.updateUser(user);
  }
}
