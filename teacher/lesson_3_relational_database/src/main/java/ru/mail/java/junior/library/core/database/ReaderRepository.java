package ru.mail.java.junior.library.core.database;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ru.mail.java.junior.library.core.domain.Reader;

//@Component
//@Transactional
public class ReaderRepository {

	@Autowired private SessionFactory sessionFactory;


	public void save(Reader reader) {
		sessionFactory.getCurrentSession().save(reader);
	}

	public Reader findById(Long id) {
		return sessionFactory.getCurrentSession().get(Reader.class, id);
	}

}