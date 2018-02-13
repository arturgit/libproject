import { Component } from '@angular/core';
import { ServerHttp } from './core/server-http.service';
import { Book } from './core/book';
import { Response } from '@angular/http/src/static_response';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  public readonly getAllUrl = 'lib';
  public readonly getByNameUrl = 'getBooksByName';
  public readonly getByAuthorUrl = 'getBooksByAuthor';
  public readonly createBookUrl = 'book';

  public searchString: string;
  public name: string;
  public author: string;
  public books: Book[] = [];

  constructor(
    private serverHttp: ServerHttp
  ) {}

  public search(): void {
    this.serverHttp.get(this.getAllUrl)
        .subscribe((resp: any) => {
          this.books = resp;
        });
  }

  public searchByName(): void {
    this.serverHttp.post(this.getByNameUrl, this.searchString)
        .subscribe((resp: any) => {
          this.books = resp;
        });
  }

  public searchByAuthor(): void {
    this.serverHttp.post(this.getByAuthorUrl, this.searchString)
        .subscribe((resp: any) => {
          this.books = resp;
        });
  }

  public create(): void {
    this.serverHttp.post(this.createBookUrl, new Book(null, this.name, this.author))
        .subscribe(() => {
          this.name = null;
          this.author = null;
        });
  }

}
