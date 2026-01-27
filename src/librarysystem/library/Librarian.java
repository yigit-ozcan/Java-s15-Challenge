package librarysystem.library;

import librarysystem.people.Reader;

public class Librarian {

    private String name;
    private String password;

    public void searchBook() {

    }

    public void verifyMember() {

    }

    public void  issueBook() {

    }

    public int calculateFine() {
        return 10;
    }

    public void createBill(Reader reader) {
        int fine = calculateFine();
        reader.getRecord().addBalance(fine);
    }

    public void returnBook() {

    }
}
