package librarysystem.books;

public class Magazines extends Book{

    @Override
    public void display() {
        System.out.println("[MAGAZINE] " + getTitle() + " - " + getCurrent());
    }

}
