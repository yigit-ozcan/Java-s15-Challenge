package librarysystem.library;

import librarysystem.books.Book;
import librarysystem.enums.BookStatus;
import librarysystem.people.Reader;

import java.util.*;

public class Library {


    private static final int BOOK_FEE = 10;

    private List<Book> books;
    private Set<Reader> readers;
    private Map<Integer, Book> bookMap = new HashMap<>();

    public void getBooks() {
        showBook();
    }

    public void setBooks(List<Book> books) {
        this.books = books;

        if (books != null) {
            for (Book book : books) {
                bookMap.put(book.getBookID(), book);
            }
        }
    }

    public void getReader() {

        if(readers == null || readers.isEmpty()) {
            System.out.println("No readers registered.");
            return;
        }

        for (Reader reader : readers) {
            System.out.println(reader.whoYouAre());
        }
    }

    public void setReaders(Set<Reader> readers) {
        this.readers = readers;
    }

    public List<Book> getBooksList() {
        return books;
    }

    public void newBook(Book book) {

        if (book == null) {
            return;
        }

        if (books == null) {
            books = new ArrayList<>();
        }

        books.add(book);

        bookMap.put(book.getBookID(), book);
    }

    public Book findBookById(int id) {
        return bookMap.get(id);
    }

    public Book findBookByName(String title) {

        if (books == null || title == null) {
            return null;
        }

        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }

        return null;
    }

    public List<Book> findBooksByAuthor(String authorName) {

        List<Book> result = new ArrayList<>();

        if (books == null || authorName == null) {
            return result;
        }

        for (Book book : books) {
            if (book.getAuthor() != null &&
                    book.getAuthor().whoYouAre().toLowerCase()
                            .contains(authorName.toLowerCase())) {

                result.add(book);
            }
        }

        return result;
    }

    public void listBooksByCategory(Class<? extends Book> category) {

        if (books == null) {
            return;
        }

        for (Book book : books) {
            if (category.isInstance(book)) {
                book.display();
            }
        }
    }

    public void lendBook(Book book, Reader reader) {

        if (book == null || reader == null || reader.getRecord() == null) {
            return;
        }

        if (book.getCurrent() == BookStatus.AVAILABLE
                && reader.getRecord().getNoBookIssued() < reader.getRecord().getMaxBookLimit()) {

            book.updateStatus(BookStatus.ISSUED);
            book.setOwner(reader);

            reader.borrowBook(book);
            reader.getRecord().addBalance(BOOK_FEE);
        }
    }

    public void takeBackBook(Book book, Reader reader) {

        if (book == null || reader == null || reader.getRecord() == null) {
            return;
        }

        reader.returnBook(book);
        reader.getRecord().decBookIssued();
        reader.getRecord().addBalance(-BOOK_FEE);

        book.updateStatus(BookStatus.AVAILABLE);
        book.setOwner(null);
    }


    public void showBook() {

        if(books != null) {
            for(Book book: books) {
                book.display();
            }
        }
    }

    public void removeBook(Book book) {

        if (book == null || books == null) {
            return;
        }

        if (book.getCurrent() == BookStatus.ISSUED) {
            System.out.println("Book is currently issued. Cannot be removed.");
            return;
        }

        books.remove(book);
        bookMap.remove(book.getBookID());

        System.out.println("Book removed: " + book.getTitle());
    }

}
