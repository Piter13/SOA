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
	private EntityManager em;

	@EJB
	CastleRepository castleRepository;

	public Optional<Mag> findOne(int id) {
		Query query = em.createNamedQuery("mag.specificMag");
		query.setParameter("id", id);
		return Optional.ofNullable((Mag) query.getSingleResult());
	}

	public List<Mag> findAll() {
		Query query = em.createNamedQuery("mag.allMags");
		List<Mag> results = query.getResultList();
		return results;
	}

	public void save(Mag mag) {
		em.persist(mag);
	}

	public void update(Mag mag) {
		em.merge(mag);
	}

	public void delete(int id) {
		Query query = em.createNamedQuery("mag.deleteMag");
		query.setParameter("id", id);
		query.executeUpdate();
	}

	public void deleteMagsInCastle(int id) {
		Query query = em.createNamedQuery("mag.deleteMagsInCastle");
		query.setParameter("castle", castleRepository.findOne(id).get());
		query.executeUpdate();
	}
}