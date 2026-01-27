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

    public void purchaseBook(Book book) {
    }

    public void borrowBook(Book book) {

        if (books != null && record != null) {
            books.add(book);
            record.incBookIssued();
        }
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
        return null;
    }
}
