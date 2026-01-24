package librarysystem.people;

import librarysystem.books.Book;

import java.util.List;

public class Reader extends Person{
    private List<Book> books;

    public void purchaseBook(Book book){};
    public void borrowBook(Book book){};
    public void returnBook(Book book){};
    public void showBooks(){};

    @Override
    public String whoYouAre(){};
}
