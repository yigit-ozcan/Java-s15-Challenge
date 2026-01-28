package librarysystem.books;


import librarysystem.enums.BookStatus;
import librarysystem.people.Author;
import librarysystem.people.Person;

import java.util.Date;

public abstract class Book {

    private int bookID;
    private Author author;
    private String name;
    private double price;
    private BookStatus status;
    private int edition;
    private Date dateOfPurchase;

    public String getTitle() {
        return null;
    }

    public Author getAuthor() {
        return null;
    }

    public Person getOwner() {
        return null;
    }

    public BookStatus getCurrent() {
        return null;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCurrent(BookStatus status) {
        this.status = status;
    }


    public void display() {
    }

    public void updateStatus(BookStatus status) {
    }
}
