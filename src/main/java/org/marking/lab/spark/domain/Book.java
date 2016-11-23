package org.marking.lab.spark.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data @AllArgsConstructor @EqualsAndHashCode
public class Book {
	
	private long id;
	private String isbn;
	private String title;
	private String author;
	
	public Book() {
	}
}
