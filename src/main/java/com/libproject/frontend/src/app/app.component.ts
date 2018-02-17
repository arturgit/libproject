import { Component } from '@angular/core';
import { ServerHttp } from './core/server-http.service';
import { Book } from './core/book';
import { Response } from '@angular/http/src/static_response';
import { Employee } from './core/employee';

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
  public readonly createEmployeeUrl = 'employee';
  public readonly getAllEmployeesUrl = 'employee';
  public readonly loadEBookUrl = '';

  public searchString: string;
  public name: string;
  public author: string;
  public books: Book[] = [];
  public firstname: string;
  public lastname: string;
  public employees: Employee[] = [];
  public selectedEmployee: Employee = null;
  public employeeBooks: Set<Book> = new Set();

  constructor(
    private serverHttp: ServerHttp
  ) {}

  public search(): void {
    this.serverHttp.get(this.getAllUrl)
        .subscribe((resp: any) => {
          this.books = resp;
        });
  }

  public loadEmployees(): void {
    this.serverHttp.get(this.getAllEmployeesUrl)
        .subscribe((resp: any) => {
          this.employees = resp;
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

  public createBook(): void {
    this.serverHttp.post(this.createBookUrl, new Book(null, this.name, this.author))
        .subscribe(() => {
          this.name = null;
          this.author = null;
        });
  }

  public createEmployee(): void {
    this.serverHttp.post(this.createEmployeeUrl, new Employee(null, this.firstname, this.lastname))
        .subscribe(() => {
          this.firstname = null;
          this.lastname = null;
        });
  }

  public selectEmployee(employee: Employee): void {
    this.selectedEmployee = employee;
    this.employeeBooks = new Set<Book>();
    // this.serverHttp.get(this.loadEBookUrl)
    //     .subscribe((resp: any) => {
    //       this.employeeBooks = new Set(resp);
    //     });
  } 

  public selectEBook(current: boolean, book: Book): void {
    console.log(current, book);
    current
      ? this.employeeBooks.delete(book)
      : this.employeeBooks.add(book);
  }

}
