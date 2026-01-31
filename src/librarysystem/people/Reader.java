package librarysystem.people;

import librarysystem.books.Book;
import librarysystem.records.member_Record;

import java.util.List;

public class Reader extends Person {

    private List<Book> books;
    private member_Record record;

    public member_Record getRecord() {
        return record;
    }

    public List<Book> getBooksList() {
        return books;
    }

    public void setRecord(member_Record record) {
        this.record = record;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    public void purchaseBook(Book book) {
    }

    public void borrowBook(Book book) {

        if (book == null || books == null || record == null) {
            return;
        }

        if (books.contains(book)) {
            System.out.println("You already borrowed this book.");
            return;
        }

        books.add(book);
        record.incBookIssued();
    }


    public void returnBook(Book book) {

        if( books != null && books.contains(book)) {

            books.remove(book);
        }
    }

    public void showBooks() {

        if(books != null) {
            for(Book book: books) {
                System.out.println("Book: " + book.getTitle()
                    + ", Status: " + book.getCurrent());
            }
        }
    }

    @Override
    public String whoYouAre() {
        return "Reader: " + name;
    }

}
