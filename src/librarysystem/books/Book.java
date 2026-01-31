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
    private Person owner;

    public int getBookID() {
        return bookID;
    }

    public String getTitle() {
        return name;
    }

    public Author getAuthor() {
        return author;
    }

    public Person getOwner() {
        return owner;
    }

    public BookStatus getCurrent() {
        return status;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
    }

    public void setTitle(String title) {
        this.name = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setOwner(Person owner) {
        this.owner = owner;
    }

    public void setCurrent(BookStatus status) {
        this.status = status;
    }

    public void display() {
        System.out.println(
                "Title: " + name +
                        ", Author: " + (author != null ? author.whoYouAre() : "Unknown") +
                        ", Status: " + status +
                        ", Owner: " + (owner != null ? owner.whoYouAre() : "None")
        );
    }

    public void updateStatus(BookStatus status) {
        this.status = status;
    }
}
