package librarysystem.people;

import librarysystem.books.Book;

import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public void newBook(Book book){};
    public void showBooks(){};
    @Override
    public String whoYouAre(){};
}
