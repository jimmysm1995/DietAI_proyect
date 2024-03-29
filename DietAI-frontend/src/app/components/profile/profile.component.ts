import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/User';
import { UserService } from 'src/app/services/user.service';
import { UserStore } from '../../store/userStore';
import { QuotesService } from '../../services/quotes.service';


@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css'],

})
export class ProfileComponent {
  public user: User = new User();
  public frase: string = '';
  constructor(
    private userService: UserService,
    private userStore: UserStore,
    private quotesService: QuotesService
    ) {}
  ngOnInit(): void {
    this.userStore.subscribeUser((user) => {
      this.user = user
    })
    //al estado interno del componente que obtenga el usuario del store lo guardamos en la variable user
    this.user = this.userStore.user
    this.quotesService.getRandomQuote().then(quote => {
      this.frase = quote
    })
  }
  cerrarModal() {
    document.getElementById('close')?.click();
  }

  obtenerDieta() {
    // this.dietServicce.getDieta().then(dieta => {
      
    // })
  }

}
