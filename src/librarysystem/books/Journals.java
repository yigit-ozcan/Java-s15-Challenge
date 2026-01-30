package librarysystem.books;

public class Journals extends Book{

    @Override
    public void display() {
        System.out.println("[JOURNAL] " + getTitle() + " - " + getCurrent());
    }

}
