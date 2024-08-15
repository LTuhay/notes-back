package app.services;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Category;
import app.entities.Note;
import app.repository.ICategoryRepository;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private ICategoryRepository categoryRepo;

	@Override
	public List<Category> findAll() {		
		return categoryRepo.findAll();
	}

	@Override
	public Optional<Category> findById(Long id) {		
		return categoryRepo.findById(id);
	}

	@Override
	public Category save(Category category) {
		return categoryRepo.save(category);
	}

	@Override
	public void deleteById(Long id) {
		categoryRepo.deleteById(id);
	}
	
	@Override
	public Optional<Category> findByName(String name) {		
		return categoryRepo.findByName(name);
	}

}