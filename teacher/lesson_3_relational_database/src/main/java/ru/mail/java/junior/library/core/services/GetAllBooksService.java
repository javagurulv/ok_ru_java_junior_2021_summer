package ru.mail.java.junior.library.core.services;

import javax.transaction.Transactional;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.domain.Book;
import ru.mail.java.junior.library.core.requests.GetAllBooksRequest;
import ru.mail.java.junior.library.core.responses.GetAllBooksResponse;

@Component
@Transactional
public class GetAllBooksService {

	@Autowired private JpaBookRepository bookRepository;

	public GetAllBooksResponse execute(GetAllBooksRequest request) {
		List<Book> books = bookRepository.findAll();
		return new GetAllBooksResponse(books);
	}

}