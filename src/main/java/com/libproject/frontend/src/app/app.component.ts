import { Component } from '@angular/core';
import { ServerHttp } from './core/server-http.service';
import { Book } from './core/book';
import { Response } from '@angular/http/src/static_response';
import { Employee } from './core/employee';
import { BookWrapper } from './core/book-wrapper';

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
  public readonly loadEBookUrl = 'books/';
  public readonly selectEBookUrl = 'selectbook/';

  public searchString: string;
  public name: string;
  public author: string;

  public books: Book[] = [];
  public selectedBook: Book;
  public bookEmployees: Employee[] = [];

  public firstname: string;
  public lastname: string;
  
  public employees: Employee[] = [];
  public selectedEmployee: Employee = null;
  public employeeBooks: BookWrapper[] = [];

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
    this.employeeBooks = this.books.map((book: Book) => new BookWrapper(book));
    this.serverHttp.get(this.loadEBookUrl + employee.id)
        .subscribe((resp: any[]) => {
          resp.forEach((bookDTO: Book) => {
            let bookWrapper = this.employeeBooks
                .find((bookWrapper: BookWrapper) => bookWrapper.book.id === bookDTO.id);
            bookWrapper.selected = true;
          });
          this.employeeBooks = [...this.employeeBooks];
        });
  } 

  public selectEBook(bookWrapper: BookWrapper): void {
    let url = this.selectEBookUrl + this.selectedEmployee.id + '/' + bookWrapper.book.id;
    this.serverHttp.get(url).subscribe();
  }

  public selectBook(book): void {
    this.selectedBook = book;
    this.serverHttp.get('book/'+book.id+'/employees')
        .subscribe((empl: Employee[]) => this.bookEmployees = empl);
  }
}
