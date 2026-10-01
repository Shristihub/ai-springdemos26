package com.bookapp.service;

import java.util.List;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;

public interface IBookService {

	List<Book> getAll();
	Book getById(int bookId) throws BookNotFoundException;;
	List<Book> getByTitleContains(String title) throws BookNotFoundException;
	List<Book> getByAuthCategory(String author, String category) throws BookNotFoundException;;
	List<Book> getByLesserPrice(double price) throws BookNotFoundException;;
}
