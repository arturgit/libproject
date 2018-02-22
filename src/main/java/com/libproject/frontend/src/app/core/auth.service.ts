import { Injectable } from "@angular/core";


@Injectable()
export class AuthService {
    public isLogged = false;

    constructor() {}

    public login(): void {
        this.isLogged = true;
    }
}