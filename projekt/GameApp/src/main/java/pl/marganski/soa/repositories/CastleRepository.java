package pl.marganski.soa.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.marganski.soa.jpa.entities.Castle;

@LocalBean
@Stateless
public class CastleRepository {
	@PersistenceContext(unitName = "GameApp")
	private EntityManager entityManager;

	public Optional<Castle> findOne(int id) {
		Query query = entityManager.createNamedQuery("castle.specificCastle");
		query.setParameter("id", id);
		return Optional.ofNullable((Castle) query.getSingleResult());
	}

	public List<Castle> findAll() {
		Query query = entityManager.createNamedQuery("castle.allCastles");
		List<Castle> results = query.getResultList();
		return results;
	}

	public void save(Castle castle) {
		entityManager.persist(castle);
	}

	public void update(Castle castle) {
		entityManager.merge(castle);
	}

	public void delete(int id) {
		Query query = entityManager.createNamedQuery("castle.deleteCastle");
		query.setParameter("id", id);
		query.executeUpdate();
	}
}
