package org.marking.lab.spark.repository;

import static java.util.Objects.isNull;
import static org.marking.lab.spark.database.tables.Book.BOOK;

import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.jooq.DSLContext;
import org.marking.lab.spark.database.tables.records.BookRecord;
import org.marking.lab.spark.domain.Book;

@Singleton
public class SQLBookRepository implements BookRepository {

	@Inject
	private DSLContext context;
	
	
	@Override
	public void save(Book book) {
		context
			.insertInto(BOOK, BOOK.TITLE, BOOK.AUTHOR).values(book.getTitle(), book.getAuthor())
			.execute();
	}

	@Override
	public Optional<Book> findById(long id) {
		
		final BookRecord record = context
				.selectFrom(BOOK).where(BOOK.ID.eq(id))
				.fetchOne();
		
		if(isNull(record))
			return Optional.empty();
		
		return Optional.of(new Book(record.getId(), 
				record.getIsbn(), record.getTitle(), record.getAuthor()));
	}
}
