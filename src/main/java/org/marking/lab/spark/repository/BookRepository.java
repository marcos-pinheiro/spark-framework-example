package org.marking.lab.spark.repository;

import java.util.Optional;

import org.marking.lab.spark.domain.Book;

public interface BookRepository {
	
	void save(Book book);
	
	Optional<Book> findById(long id);
	
}
