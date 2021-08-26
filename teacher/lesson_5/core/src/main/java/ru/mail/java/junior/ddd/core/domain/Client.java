package ru.mail.java.junior.ddd.core.domain;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client extends BaseEntity {

    @Id
    @GeneratedValue(generator = "clients_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "clients_seq", sequenceName = "clients_seq", allocationSize = 1)
    @Column(name="id", nullable = false)
    private Long id;

    @Column(name="login", nullable = false)
    private String login;

    @Column(name="password", nullable = false)
    private String password;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (id != null ? !id.equals(client.id) : client.id != null) return false;
        if (login != null ? !login.equals(client.login) : client.login != null) return false;
        return password != null ? password.equals(client.password) : client.password == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}
