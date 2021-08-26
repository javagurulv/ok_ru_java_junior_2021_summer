package ru.mail.java.junior.ddd.core.database;

import ru.mail.java.junior.ddd.core.domain.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {

}
