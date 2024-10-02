package com.keyin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class bookModel {

    private static final String URL = "jdbc:postgresql://localhost:5432/My_Florida_Library";
    private static final String USER = "postgres";
    private static final String PASSWORD = "password";


    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        String query = "SELECT * FROM books";

        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Book book = new Book(
                        Long.parseLong(rs.getString("ISBN")),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("genre"),
                        rs.getInt("year_published")
                );
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }


    public void createBook(Book book) {
        String query = "INSERT INTO books (ISBN, title, author, genre, year_published) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setLong(1, book.getISBN());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getGenre());
            pstmt.setInt(5, book.getYearPublished());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void updateBook(String ISBN, Book book) {
        String query = "UPDATE books SET title = ?, author = ?, genre = ?, year_published = ? WHERE ISBN = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getGenre());
            pstmt.setInt(4, book.getYearPublished());
            try {
                pstmt.setLong(5, Long.parseLong(ISBN));
            } catch (NumberFormatException e) {
                System.err.println("Invalid ISBN format: " + ISBN);
                return;
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void deleteBook(String ISBN) {
        String query = "DELETE FROM books WHERE ISBN = ?";

        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            try {
                pstmt.setLong(1, Long.parseLong(ISBN));
            } catch (NumberFormatException e) {
                System.err.println("Invalid ISBN format: " + ISBN);
                return;
            }
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}



