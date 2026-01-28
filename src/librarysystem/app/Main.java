package librarysystem.app;

import librarysystem.library.Librarian;
import librarysystem.library.Library;
import librarysystem.people.Author;
import librarysystem.people.Reader;
import librarysystem.records.Student;

import java.util.ArrayList;
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
                    library.lendBook(null, reader);
                    break;
                case 4:
                    library.takeBackBook(null, reader);
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

        Author author1 = new Author();
        author1.name

    }
}
