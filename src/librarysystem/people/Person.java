package librarysystem.people;

public abstract class Person {
    protected String name;

    public void setName(String name) {
        this.name = name;
    }

    public abstract String whoYouAre();
}
