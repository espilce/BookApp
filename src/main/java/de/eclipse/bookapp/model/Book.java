package de.eclipse.bookapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue 
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false, unique = true)
    private String isbn;

    @Column(nullable = true)
    private String subtitle;

    @Column(nullable = true)
    private String genre;

    public Book() {
        super();
    }

    public Book(long id, String title, String author, String isbn, String subtitle, String genre) {
        super();
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.subtitle = subtitle;
        this.genre = genre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubstitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Book [author=" + author + ", genre=" + genre + ", id=" + id + ", isbn=" + isbn + ", subtitle="
                + subtitle + ", title=" + title + "]";
    }


}
