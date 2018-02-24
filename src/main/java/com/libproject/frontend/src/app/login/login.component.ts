import { Component } from '@angular/core';
import { AuthService } from '../core/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

    constructor(
        private authService: AuthService
    ) {}

    public login(): void {
        this.authService.login('a', 'b');
    }

    public reg(): void {
        this.authService.reg('a', 'b');
    }
}
