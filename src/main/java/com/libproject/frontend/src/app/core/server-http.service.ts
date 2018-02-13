import { Injectable } from '@angular/core';
import { Http, ResponseOptionsArgs, Response } from '@angular/http';

@Injectable()
export class ServerHttp {
    public readonly baseUrl = 'http://localhost:8080/';

    constructor(
        private http: Http
    ) {}

    public get(url: string, options?: ResponseOptionsArgs): any {
        return this.http.get(this.baseUrl + url, options)
            .map((resp: Response) => resp.json());
    }

    public post(url: string, body: any, options?: ResponseOptionsArgs): any {
        return this.http.post(this.baseUrl + url, body, options)
            .map((resp: Response) => resp.json());
    }
}
