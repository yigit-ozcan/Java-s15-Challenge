package librarysystem.books;

import librarysystem.enums.BookStatus;
import librarysystem.people.Author;
import librarysystem.people.Reader;
import java.time.LocalDate;

public abstract class Book {
    protected int book_ID;
    protected Author author;
    protected String name;
    protected double price;
    protected BookStatus bookStatus;
    protected int edition;
    protected LocalDate date_of_purchase;
    protected Reader reader;

    public String getTitle(){};

    
}
