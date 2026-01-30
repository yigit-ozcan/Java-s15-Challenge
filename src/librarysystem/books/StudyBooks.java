package librarysystem.books;

public class StudyBooks extends Book{

    @Override
    public void display() {
        System.out.println("[STUDY BOOK] " + getTitle() + " - " + getCurrent());
    }

}
