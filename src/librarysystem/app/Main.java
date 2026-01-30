package librarysystem.app;

import librarysystem.books.Book;
import librarysystem.books.Journals;
import librarysystem.books.StudyBooks;
import librarysystem.enums.BookStatus;
import librarysystem.library.Librarian;
import librarysystem.library.Library;
import librarysystem.people.Author;
import librarysystem.people.Reader;
import librarysystem.records.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Library library = new Library();
        Librarian librarian = new Librarian();
        Reader reader = new Reader();
        Student studentRecord = new Student();

        library.setBooks(new ArrayList<>());
        reader.setBooks(new ArrayList<>());
        reader.setRecord(studentRecord);


        //INITIAL DATA
        Author author1 = new Author();
        author1.setName("Robert Martin");

        Journals journal = new Journals();
        journal.setTitle("Clean Code");
        journal.setAuthor(author1);
        journal.setCurrent(BookStatus.AVAILABLE);

        StudyBooks studyBook = new StudyBooks();
        studyBook.setTitle("Design Patterns");
        studyBook.setAuthor(author1);
        studyBook.setCurrent(BookStatus.AVAILABLE);

        library.setBooks(new ArrayList<>());
        library.setBooks(
                new ArrayList<>() {{
                    add(journal);
                    add(studyBook);
                }}
        );

        //MENU LOOP
        while (true) {

            System.out.println("=== Library System ===");
            System.out.println("1. Show all books");
            System.out.println("2. Show my books");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Pay bill");
            System.out.println("0. Exit");
            System.out.print("Select an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.showBook();
                    break;
                case 2:
                    reader.showBooks();
                    break;
                case 3:
                    List<Book> books = library.getBooksList();

                    if(books == null || books.isEmpty()) {
                        System.out.println("No books available.");
                        break;
                    }

                    for(int i = 0; i < books.size(); i++) {
                        System.out.println(i + " - " + books.get(i).getTitle());
                    }

                    System.out.println("Select book number: ");
                    int index = scanner.nextInt();

                    if(index < 0 || index >= books.size()) {
                        System.out.println("Invalid selection.");
                        break;
                    }

                    Book selectedBook = books.get(index);
                    library.lendBook(selectedBook, reader);
                    break;
                case 4:
                    List<Book> myBooks = reader.getBooksList();

                    if (myBooks == null || myBooks.isEmpty()) {
                        System.out.println("You have no books.");
                        break;
                    }

                    for (int i = 0; i < myBooks.size(); i++) {
                        System.out.println(i + " - " + myBooks.get(i).getTitle());
                    }

                    System.out.println("Select book number to return: ");
                    int returnIndex = scanner.nextInt();

                    if(returnIndex < 0 || returnIndex >= myBooks.size()) {
                        System.out.println("Invalid selection.");
                        break;
                    }

                    Book bookToReturn = myBooks.get(returnIndex);
                    library.takeBackBook(bookToReturn, reader);
                    break;
                case 5:
                    if(reader.getRecord() != null) {
                        reader.getRecord().payBill();
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option");

            }
        }

    }
}
