package org.marking.lab.spark.controller;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.marking.lab.spark.domain.Book;
import org.marking.lab.spark.repository.BookRepository;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;


@Singleton
public class BookController {
	
	@Inject Gson gson;
	@Inject BookRepository repository;
	
	
	public Book createBook(Request request, Response response) {
		
		Book book = gson.fromJson(request.body(), Book.class);
		repository.save(book);
		
		return book;
	}
	
	public Book getBookById(Request request, Response response) {
		
		final long id = Long.parseLong(request.params("id"));
		
		return repository.findById(id)
				.orElseThrow(RuntimeException::new);
	}
}
