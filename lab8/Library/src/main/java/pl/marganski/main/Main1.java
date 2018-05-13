package pl.marganski.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import pl.marganski.lib.Author;
import pl.marganski.lib.Book;
import pl.marganski.lib.Rent;
import pl.marganski.lib.UserEntity;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main1 {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("lab8_library");
		EntityManager manager = factory.createEntityManager();

		Author author0 = new Author("John", "Carlin", null);
		Author author1 = new Author("John", "Eldredge", null);
		Author author2 = new Author("Artur Conan", "Doyle", null);

		Book book0 = new Book("RAFA", author0, null);
		Book book1 = new Book("Knowing Mandela", author0, null);

		Book book2 = new Book("Dzikie serce. Têsknoty mêskiej duszy", author1, null);
		Book book3 = new Book("Szukajcie tego co w górze", author1, null);

		Book book4 = new Book("A Study in Scarlet", author1, null);
		Book book5 = new Book("The Sign of the Four", author1, null);

		UserEntity user0 = new UserEntity("Aleksy", null);
		UserEntity user1 = new UserEntity("Maciej", null);
		UserEntity user2 = new UserEntity("Piotr", null);

		Timestamp dateBorrow = java.sql.Timestamp.valueOf("2017-10-13 10:10:10.0");
		Timestamp dateReturn = java.sql.Timestamp.valueOf("2017-12-13 10:10:10.0");
		Set<Book> books0 = new HashSet<Book>(Arrays.asList(book0, book1, book3));
		Rent rent0 = new Rent(dateBorrow, dateReturn, user0, book0);
		Rent rent1 = new Rent(dateBorrow, dateReturn, user0, book1);
		Rent rent2 = new Rent(dateBorrow, dateReturn, user0, book3);

		manager.getTransaction().begin();

		manager.persist(rent0);
		manager.persist(rent1);
		manager.persist(rent2);
		manager.getTransaction().commit();

	}
}
