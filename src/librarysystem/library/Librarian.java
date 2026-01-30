package librarysystem.library;

import librarysystem.books.Book;
import librarysystem.people.Reader;

public class Librarian {

    private String name;
    private String password;

    public void searchBook(Library library) {
        if (library == null) {
            System.out.println("Library not available.");
            return;
        }
        library.showBook();
    }

    public boolean verifyMember(Reader reader) {
        return reader != null && reader.getRecord() != null;
    }

    public void issueBook(Library library, Book book, Reader reader) {

        if (!verifyMember(reader)) {
            System.out.println("Member verification failed.");
            return;
        }

        library.lendBook(book, reader);
    }

    public int calculateFine() {
        return 10;
    }

    public void createBill(Reader reader) {
        if (reader == null || reader.getRecord() == null) {
            return;
        }

        int fine = calculateFine();
        reader.getRecord().addBalance(fine);
    }

    public void returnBook(Library library, Book book, Reader reader) {

        if (!verifyMember(reader)) {
            System.out.println("Member verification failed.");
            return;
        }

        library.takeBackBook(book, reader);
    }

}
