package com.keyin;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private bookModel bookModel;

    @GetMapping("/books")
    public List<Book> getBooks() {
        return bookModel.getBooks();
    }

    @PostMapping
    public void createBook(@RequestBody Book book) {
        bookModel.createBook(book);
    }

    @PutMapping("/{isbn}")
    public void updateBook(@PathVariable String isbn, @RequestBody Book book) {
        bookModel.updateBook(isbn, book);
    }



    @DeleteMapping("/books/{isbn}")
    public @ResponseBody String deleteBook(@PathVariable String ISBN) {
        try {
            bookModel.deleteBook(ISBN);
            return "Book with ISBN " + ISBN + " has been deleted successfully";
        } catch (NumberFormatException e) {
            return "Invalid ISBN format: " + ISBN;
        }
    }}