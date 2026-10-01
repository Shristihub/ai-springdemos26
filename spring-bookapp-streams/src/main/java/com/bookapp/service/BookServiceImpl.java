package com.bookapp.service;

import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookapp.exception.BookNotFoundException;
import com.bookapp.model.Book;
import com.bookapp.util.BookDetails;

@Service
public class BookServiceImpl implements IBookService{
	
	private BookDetails bookDetails;

	//autowiring bookdetails into bookserviceimpl	
	public BookServiceImpl(BookDetails bookDetails) {
		super();
		this.bookDetails = bookDetails;
	}

	@Override
	public List<Book> getAll() {
		return bookDetails.showBooks().stream()
			.sorted(Comparator.comparing(Book::getTitle))
			.toList();
	}

	@Override
	public Book getById(int bookId) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByTitleContains(String title) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByAuthCategory(String author, String category) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getByLesserPrice(double price) throws BookNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

}
