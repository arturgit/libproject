import { Component } from '@angular/core';
import { AuthService } from '../core/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

    public loginValue: string;
    public passwordValue: string;

    constructor(
        private authService: AuthService
    ) {}

    public login(loginValue, passwordValue): void {
        this.authService.login(loginValue, passwordValue);
    }

    public reg(loginValue, passwordValue): void {
        this.authService.reg(loginValue, passwordValue);
    }
}
