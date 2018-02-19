import { Book } from './book';

export class BookWrapper {

    constructor(
        public book: Book,
        public selected: boolean = false
    ) {}

}