package ru.mail.java.junior.library.core.database;

import java.util.List;
import java.util.Optional;

import ru.mail.java.junior.library.core.domain.Book;

public interface BookRepository {

	void save(Book book);

	Optional<Book> getById(Long id);

	boolean deleteById(Long id);

	List<Book> getAllBooks();

	List<Book> findByTitle(String title);

	List<Book> findByAuthor(String author);

	List<Book> findByTitleAndAuthor(String title, String author);

}
