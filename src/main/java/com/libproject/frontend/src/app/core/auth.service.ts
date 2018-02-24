import { Injectable } from "@angular/core";
import { ServerHttp } from './server-http.service';
import { token } from './token';

@Injectable()
export class AuthService {
    private readonly loginUrl = 'users/login';

    private readonly regUrl = 'users/singup';

    public isLogged = false;

    constructor(private serverHttp: ServerHttp) {}

    public login(username: string, password: string): void {
        let body = {
            login: username, 
            password: password
        };
        this.serverHttp.post(this.loginUrl, body)
            .subscribe(resp => {
                if (resp) {
                    token.value = resp;
                    this.isLogged = true;
                }
            });
    }

    public reg(username: string, password: string): void {
        let body = {
            login: username, 
            password: password
        };
        this.serverHttp.post(this.regUrl, body)
            .subscribe(resp => {
                if (resp) {
                    token.value = resp;
                    this.isLogged = true;
                }
            });
    }

    public logout(): void {
        token.value = null;
        this.isLogged = false;
    }
}
