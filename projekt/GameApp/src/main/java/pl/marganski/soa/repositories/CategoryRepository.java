package pl.marganski.soa.repositories;

import java.util.List;
import java.util.Optional;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import pl.marganski.soa.jpa.entities.Category;

@LocalBean
@Stateless
public class CategoryRepository {

	@PersistenceContext(unitName = "GameApp")
	private EntityManager em;

	public Optional<Category> findOne(int id) {
		Query query = em.createNamedQuery("category.specificCategory");
		query.setParameter("id", id);
		return Optional.ofNullable((Category) query.getSingleResult());
	}

	public List<Category> findAll() {
		Query query = em.createNamedQuery("category.allCategories");
		List<Category> results = query.getResultList();
		return results;
	}

}
