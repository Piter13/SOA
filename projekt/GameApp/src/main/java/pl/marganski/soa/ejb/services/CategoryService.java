package pl.marganski.soa.ejb.services;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import pl.marganski.soa.jpa.entities.Category;
import pl.marganski.soa.repositories.CategoryRepository;

@LocalBean
@Stateless
@Transactional
public class CategoryService {
	
	@EJB
	private CategoryRepository categoryRepository;
	
	public List<Category> getAllCategories() {
		return categoryRepository.findAll()
								.stream()
								.collect(Collectors.toList());
	}
	
	public Category getCategory(int id) {
		return categoryRepository.findOne(id)
									.orElse(null);
	}

}
