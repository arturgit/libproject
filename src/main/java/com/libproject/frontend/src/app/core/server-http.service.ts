import { Injectable } from '@angular/core';
import { Http, ResponseOptionsArgs, Response, Headers } from '@angular/http';
import { RequestOptions } from '@angular/http/src/base_request_options';
import { token } from './token';

@Injectable()
export class ServerHttp {
    public readonly baseUrl = 'http://localhost:8080/';

    constructor(
        private http: Http
    ) {}

    public get(url: string, options?: ResponseOptionsArgs): any {
        const headers = new Headers();
        headers.append('x-auth-token', token.value);
        return this.http.get(this.baseUrl + url, {headers: headers})
            .map((resp: Response) => resp.json());
    }

    public post(url: string, body: any, options?: ResponseOptionsArgs): any {
        const headers = new Headers();
        headers.append('x-auth-token', token.value);
        return this.http.post(this.baseUrl + url, body, {headers: headers})
            .map((resp: any) => {
                return resp._body;
            });
    }
}
