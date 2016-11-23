package org.marking.lab.spark.config;

import static spark.Spark.*;

import javax.inject.Inject;

import org.marking.lab.spark.controller.BookController;

import com.google.gson.Gson;

public class ApplicationRoutes {
	
	@Inject Gson gson;
	@Inject BookController bookController;
	
	public void init() {
		
		get("/books/:id", bookController::getBookById, gson::toJson);
		
		post("/books", bookController::createBook, gson::toJson);
	}
}
