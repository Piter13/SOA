package soa.lab8.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import soa.lab8.models.Rent;
import soa.lab8.models.Author;
import soa.lab8.models.Book;
import soa.lab8.models.UserEntity;

public class Main {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SOA_lab8_hibernate");
		EntityManager manager = factory.createEntityManager();
		
		Author author0 = new Author("Andrzej", "Sapkowski", null);
		Author author1 = new Author("Jacek", "Dukaj", null);
		Author author2 = new Author("John Ronald Reuel", "Tolkien", null);
		
		Book book0 = new Book("Krew elfów", author0, null);
		Book book1 = new Book("Czas pogardy", author0, null);
		Book book2 = new Book("Chrzest ognia", author0, null);
		Book book3 = new Book("Wie¿a Jaskó³ki", author0, null);
		Book book4 = new Book("Pani Jeziora ", author0, null);
		
		Book book5 = new Book("Extensa", author1, null);
		Book book6 = new Book("Inne pieœni", author1, null);
		Book book7 = new Book("Lód", author1, null);
		Book book8 = new Book("Wroniec", author1, null);
		Book book9 = new Book("Córka ³upiezcy", author1, null);
		
		UserEntity user0 = new UserEntity("Bartek", null);
		UserEntity user1 = new UserEntity("Maciej", null);
		UserEntity user2 = new UserEntity("Pietrek", null);
		

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
