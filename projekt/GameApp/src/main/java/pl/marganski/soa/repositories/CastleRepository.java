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
	private EntityManager em;

	public Optional<Castle> findOne(int id) {
		Query q = em.createNamedQuery("castle.specificCastle");
		q.setParameter("id", id);
		return Optional.ofNullable((Castle) q.getSingleResult());
	}

	public List<Castle> findAll() {
		Query q = em.createNamedQuery("castle.allCastles");
		List<Castle> results = q.getResultList();
		return results;
	}

	public void save(Castle castle) {
		em.persist(castle);
	}

	public void update(Castle castle) {
		em.merge(castle);
	}

	public void delete(int id) {
		Query q = em.createNamedQuery("castle.deleteCastle");
		q.setParameter("id", id);
		q.executeUpdate();
	}
}
