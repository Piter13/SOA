package soa.lab8.main;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import soa.lab8.models.*;

public class Main2 {
	


	
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("SOA_lab8_hibernate");
		EntityManager manager = factory.createEntityManager();
		
		Timestamp from = java.sql.Timestamp.valueOf("2017-09-13 10:10:10.0");
		Timestamp to = java.sql.Timestamp.valueOf("2017-12-24 10:10:10.0");
		String authorName  = "Sapkowski";
		
		Query q4 = manager.createQuery("SELECT u.user_id, u.user_name from UserEntity u "
				+ "						JOIN  u.Rent r JOIN  r.Book b  JOIN  b.Author a "
				+ "						WHERE a.author_name = :authorName ");
		Query q0 = manager.createQuery("SELECT * from BOOK ");
		List<UserEntity> userEntities = q0.setParameter("authorName", authorName).getResultList(); 
	}

}
