package librarysystem.library;

import librarysystem.books.Book;
import librarysystem.enums.BookStatus;
import librarysystem.people.Reader;

import java.util.List;
import java.util.Set;

public class Library {

    private List<Book> books;
    private Set<Reader> readers;

    public void getBooks() {
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void getReader() {
    }

    public List<Book> getBooksList() {
        return books;
    }

    public void newBook() {
    }

    public void lendBook(Book book, Reader reader) {

        if (book == null || reader == null || reader.getRecord() == null) {
            return;
        }

        if (book.getCurrent() == BookStatus.AVAILABLE
                && reader.getRecord().getNoBookIssued() < reader.getRecord().getMaxBookLimit()) {

            book.updateStatus(BookStatus.ISSUED);
            reader.borrowBook(book);
        }
    }

    public void takeBackBook(Book book, Reader reader) {

        if (book == null || reader == null || reader.getRecord() == null) {
            return;
        }

        reader.returnBook(book);
        reader.getRecord().decBookIssued();
        book.updateStatus(BookStatus.AVAILABLE);
    }


    public void showBook() {

        if(books != null) {
            for(Book book: books) {
                System.out.println("Book: " + book.getTitle()
                    + ", Author: " + book.getAuthor()
                    + ", Status: " + book.getCurrent());
            }
        }
    }
}
