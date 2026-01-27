package librarysystem.people;

import librarysystem.books.Book;

import java.util.List;

public class Author extends Person{
    private List<Book> books;

    public void newBook(Book book){

    }

    public void showBooks(){

        if(books != null) {
            for(Book book: books) {
                System.out.println("Book: " + book.getTitle());
            }
        }

    }

    @Override
    public String whoYouAre(){
        return null;
    }
}
