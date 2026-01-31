package librarysystem.app;

import librarysystem.books.Book;
import librarysystem.books.Journals;
import librarysystem.books.Magazines;
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

        Author author2 = new Author();
        author2.setName("Joshua Bloch");

        //BOOK 1
        Journals journal = new Journals();
        journal.setBookID(1);
        journal.setTitle("Clean Code");
        journal.setAuthor(author1);
        journal.setCurrent(BookStatus.AVAILABLE);

        //BOOK 2
        StudyBooks studyBook = new StudyBooks();
        studyBook.setBookID(2);
        studyBook.setTitle("Design Patterns");
        studyBook.setAuthor(author1);
        studyBook.setCurrent(BookStatus.AVAILABLE);

        //BOOK 3
        Magazines magazine = new Magazines();
        magazine.setBookID(3);
        magazine.setTitle("Effective Java Monthly");
        magazine.setAuthor(author2);
        magazine.setCurrent(BookStatus.AVAILABLE);

        //Author–Book
        author1.newBook(journal);
        author1.newBook(studyBook);
        author2.newBook(magazine);

        // Library’ye ekleme (List + Map)
        List<Book> initialBooks = new ArrayList<>();
        initialBooks.add(journal);
        initialBooks.add(studyBook);
        initialBooks.add(magazine);

        library.setBooks(initialBooks);

        //MENU LOOP
        while (true) {

            System.out.println("=== Library System ===");
            System.out.println("1. Show all books");
            System.out.println("2. Show my books");
            System.out.println("3. Borrow book");
            System.out.println("4. Return book");
            System.out.println("5. Pay bill");
            System.out.println("6. Search book by ID");
            System.out.println("7. Search book by name");
            System.out.println("8. List books by author");
            System.out.println("9. List books by category");
            System.out.println("10. Remove a book");
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
                    librarian.issueBook(library, selectedBook, reader);

                    if (selectedBook.getOwner() == reader) {
                        System.out.println("Book borrowed successfully.");
                    } else {
                        System.out.println("Book could not be borrowed.");
                    }
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
                    librarian.returnBook(library, bookToReturn, reader);
                    System.out.println("Book returned successfully.");
                    break;
                case 5:
                    if(reader.getRecord() != null) {
                        reader.getRecord().payBill();
                        System.out.println("Bill paid. Current balance: " + reader.getRecord().getBalance());
                    }
                    break;
                case 6:
                    System.out.println("Enter book ID: ");
                    int id = scanner.nextInt();

                    Book bookById = library.findBookById(id);
                    if(bookById != null) {
                        bookById.display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 7:
                    scanner.nextLine();
                    System.out.print("Enter book name: ");
                    String name = scanner.nextLine();

                    Book bookByName = library.findBookByName(name);
                    if (bookByName != null) {
                        bookByName.display();
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 8:
                    scanner.nextLine();
                    System.out.print("Enter author name: ");
                    String authorName = scanner.nextLine();

                    List<Book> authorBooks = library.findBooksByAuthor(authorName);

                    if (authorBooks.isEmpty()) {
                        System.out.println("No books found for this author.");
                    } else {
                        for (Book book : authorBooks) {
                            book.display();
                        }
                    }
                    break;
                case 9:
                    System.out.println("Select category:");
                    System.out.println("1. Journals");
                    System.out.println("2. StudyBooks");
                    System.out.println("3. Magazines");

                    int cat = scanner.nextInt();

                    switch (cat) {
                        case 1:
                            library.listBooksByCategory(Journals.class);
                            break;
                        case 2:
                            library.listBooksByCategory(StudyBooks.class);
                            break;
                        case 3:
                            library.listBooksByCategory(Magazines.class);
                            break;
                        default:
                            System.out.println("Invalid category.");
                    }
                    break;
                case 10:
                    System.out.println("Enter book ID to remove: ");
                    int removeId = scanner.nextInt();

                    Book bookToRemove = library.findBookById(removeId);

                    if(bookToRemove != null) {
                        library.removeBook(bookToRemove);
                    } else {
                        System.out.println("Book not found.");
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
