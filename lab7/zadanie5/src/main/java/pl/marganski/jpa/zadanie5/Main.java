package pl.marganski.jpa.zadanie5;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("zadanie5");
		EntityManager manager = factory.createEntityManager();
		try {
			Kot kot1 = new Kot("janek");
			Kot kot2 = new Kot("Filemon");
			Kot kot3 = new Kot("bonifacy");

			Pies pies1 = new Pies("Reksio");
			Pies pies2 = new Pies("Pluto");
			Pies pies3 = new Pies("Ancymon");

			manager.getTransaction().begin();
			manager.persist(kot1);
			manager.persist(kot2);
			manager.persist(kot3);
			manager.persist(pies1);
			manager.persist(pies2);
			manager.persist(pies3);
			manager.getTransaction().commit();
			System.out.println("Zapisano w bazie: " + kot1);
			System.out.println("Zapisano w bazie: " + kot2);
			System.out.println("Zapisano w bazie: " + kot3);
			System.out.println("Zapisano w bazie: " + pies1);
			System.out.println("Zapisano w bazie: " + pies2);
			System.out.println("Zapisano w bazie: " + pies3);
		} catch (Exception e) {
			System.err.println("Blad przy dodawaniu rekordu: " + e);
		}

	}

}