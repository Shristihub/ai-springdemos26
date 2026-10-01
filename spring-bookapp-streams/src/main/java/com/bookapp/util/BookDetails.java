package com.bookapp.util;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bookapp.model.Book;
@Component
public class BookDetails {

	// returns a list of books
	public List<Book> showBooks() {
		return Arrays.asList(new Book("Java in Action", 1, "Stephen", "Technical", 1200),
				new Book("Placebo", 2, "Joe", "selfhelp", 850),
				new Book("Head First Java", 3, "Kathy", "Technical", 920),
				new Book("Javascript for beginners", 4, "Jacob", "Technical", 1100),
				new Book("Conversations", 5, "Joe", "selfhelp", 1002),
				new Book("Mind Matters", 6, "Joe", "selfhelp", 650));
	}
}
