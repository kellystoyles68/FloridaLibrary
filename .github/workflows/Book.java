package com.keyin;

public class Book {
    private long ISBN;
    private String title;
    private String author;
    private String genre;
    private int yearPublished;

    public Book(long ISBN, String title, String author, String genre, int yearPublished) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.yearPublished = yearPublished;
    }

    public long getISBN() {
        return ISBN;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }

    public int getYearPublished() {
        return yearPublished;
    }
}
