package ru.mail.java.junior.library.core.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.database.jpa.JpaBookRepository;
import ru.mail.java.junior.library.core.domain.Book;
import ru.mail.java.junior.library.core.requests.Ordering;
import ru.mail.java.junior.library.core.requests.Paging;
import ru.mail.java.junior.library.core.requests.SearchBooksRequest;
import ru.mail.java.junior.library.core.responses.CoreError;
import ru.mail.java.junior.library.core.responses.SearchBooksResponse;
import ru.mail.java.junior.library.core.services.validators.SearchBooksRequestValidator;

@Component
@Transactional
public class SearchBooksService {

	@Value("${search.ordering.enabled}")
	private boolean orderingEnabled;

	@Value("${search.paging.enabled}")
	private boolean pagingEnabled;

	@Autowired private JpaBookRepository bookRepository;
	@Autowired private SearchBooksRequestValidator validator;

	public SearchBooksResponse execute(SearchBooksRequest request) {
		List<CoreError> errors = validator.validate(request);
		if (!errors.isEmpty()) {
			return new SearchBooksResponse(null, errors);
		}

		List<Book> books = search(request);
		books = order(books, request.getOrdering());
		books = paging(books, request.getPaging());

		return new SearchBooksResponse(books, null);
	}

	private List<Book> search(SearchBooksRequest request) {
		List<Book> books = new ArrayList<>();
		if (request.isTitleProvided() && !request.isAuthorProvided()) {
			books = bookRepository.findByTitle(request.getTitle());
		}
		if (!request.isTitleProvided() && request.isAuthorProvided()) {
			books = bookRepository.findByAuthor(request.getAuthor());
		}
		if (request.isTitleProvided() && request.isAuthorProvided()) {
			books = bookRepository.findByTitleAndAuthor(request.getTitle(), request.getAuthor());
		}
		return books;
	}

	private List<Book> order(List<Book> books, Ordering ordering) {
		if (orderingEnabled && (ordering != null)) {
			Comparator<Book> comparator = ordering.getOrderBy().equals("title")
					? Comparator.comparing(Book::getTitle)
					: Comparator.comparing(Book::getAuthor);
			if (ordering.getOrderDirection().equals("DESCENDING")) {
				comparator = comparator.reversed();
			}
			return books.stream().sorted(comparator).collect(Collectors.toList());
		} else {
			return books;
		}
	}

	private List<Book> paging(List<Book> books, Paging paging) {
		if (pagingEnabled && (paging != null)) {
			int skip = (paging.getPageNumber() - 1) * paging.getPageSize();
			return books.stream()
					.skip(skip)
					.limit(paging.getPageSize())
					.collect(Collectors.toList());
		} else {
			return books;
		}
	}

}
