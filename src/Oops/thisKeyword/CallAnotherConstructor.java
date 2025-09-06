package Oops.thisKeyword;

class Book {
    String title;
    int pages;

    Book() {
        this("Unknown", 0);
        System.out.println("using this calling other constructor");
    }

    Book(String title, int pages) {
        this.title = title;
        this.pages = pages;
    }

    void display() {
        System.out.println("Title: " + title + ", Pages: " + pages);
    }
}

public class CallAnotherConstructor {
    public static void main(String[] args) {
        Book b1 = new Book();
        Book b2 = new Book("Java Basics", 300);
        b1.display();
        b2.display();
    }
}
