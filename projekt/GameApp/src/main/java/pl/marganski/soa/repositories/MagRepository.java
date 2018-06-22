package pl.marganski.soa.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.marganski.soa.jpa.entities.Mag;

@LocalBean
@Stateless
public class MagRepository {

	@PersistenceContext(unitName = "GameApp")
	private EntityManager entityManager;

	@EJB
	CastleRepository castleRepository;

	public Optional<Mag> findOne(int id) {
		Query query = entityManager.createNamedQuery("mag.specificMag");
		query.setParameter("id", id);
		return Optional.ofNullable((Mag) query.getSingleResult());
	}

	public List<Mag> findAll() {
		Query query = entityManager.createNamedQuery("mag.allMags");
		List<Mag> results = query.getResultList();
		return results;
	}

	public void save(Mag mag) {
		entityManager.persist(mag);
	}

	public void update(Mag mag) {
		entityManager.merge(mag);
	}

	public void delete(int id) {
		Query query = entityManager.createNamedQuery("mag.deleteMag");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public void deleteMagsInCastle(int id) {
		Query query = entityManager.createNamedQuery("mag.deleteMagsInCastle");
		query.setParameter("castle", castleRepository.findOne(id).get());
		query.executeUpdate();
	}
	
	public List<Mag> findBestMags(int i) {
		Query query = entityManager.createNamedQuery("mag.bestMags").setMaxResults(i);
    	List<Mag> results = query.getResultList();
        return results;
	}
	
}