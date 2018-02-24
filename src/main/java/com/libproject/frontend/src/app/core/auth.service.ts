import { Injectable } from "@angular/core";
import { ServerHttp } from './server-http.service';

@Injectable()
export class AuthService {
    private readonly loginUrl = 'users/login';

    private readonly regUrl = 'users/singup';

    public isLogged = false;

    constructor(private serverHttp: ServerHttp) {}

    public login(username: string, password: string): void {
        this.serverHttp.post(this.loginUrl, {login: username, password: password})
            .subscribe(() => this.isLogged = true);
    }

    public reg(username: string, password: string): void {
        this.serverHttp.post(this.regUrl, {login: username, password: password})
            .subscribe(() => this.isLogged = true);
    }
}
