package org.marking.lab.spark.config;

import static spark.Spark.*;

import javax.inject.Inject;

import org.marking.lab.spark.controller.BookController;

import com.google.gson.Gson;

import spark.Request;
import spark.Response;

public class ApplicationRoutes {
	
	@Inject Gson gson;
	@Inject BookController bookController;
	
	public void init() {
		
		after(this::headers);
		
		get("/books/:id", bookController::getBookById, gson::toJson);
		post("/books", bookController::createBook, gson::toJson);
	}
	
	
	public void headers(Request request, Response response) {
		response.header("Content-Type", "application/json");
	}
}
