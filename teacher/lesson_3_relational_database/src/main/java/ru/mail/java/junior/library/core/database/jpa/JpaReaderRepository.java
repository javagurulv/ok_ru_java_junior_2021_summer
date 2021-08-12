package ru.mail.java.junior.library.core.database.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ru.mail.java.junior.library.core.domain.Reader;

@Repository
public interface JpaReaderRepository extends JpaRepository<Reader, Long> {


}
