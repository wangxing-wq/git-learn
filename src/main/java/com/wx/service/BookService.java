package com.wx.service;

import com.wx.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> bookList = new ArrayList<>();

    public List<Book> getAllBooks() {
        return bookList;
    }

    public Book getBookById(Long id) {
        for (Book book : bookList) {
            if (book.getId().equals(id)) {
                return book;
            }
        }
        return null;
    }

    public void addBook(Book book) {
        bookList.add(book);
    }

    public Book updateBook(Long id, Book updatedBook) {
        for (int i = 0; i < bookList.size(); i++) {
            if (bookList.get(i).getId().equals(id)) {
                bookList.set(i, updatedBook);
                return updatedBook;
            }
        }
        return null;
    }

    public boolean deleteBook(Long id) {
        return bookList.removeIf(book -> book.getId().equals(id));
    }
    
    public Book createBook(Book book){
        bookList.add(book);
        return book;
    }
}
