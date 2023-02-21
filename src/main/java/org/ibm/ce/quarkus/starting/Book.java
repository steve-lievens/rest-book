package org.ibm.ce.quarkus.starting;

public class Book {

    public int id;
    public String title;
    public String author;
    public int yearOfPublication;
    public String genre;

    // ======================================
    // = Constructors =
    // ======================================

    public Book(String title) {
        this.title = title;
    }

    public Book() {
    }

    public Book(int id, String title, String author, int yearOfPublication, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.yearOfPublication = yearOfPublication;
        this.genre = genre;
    }
}
