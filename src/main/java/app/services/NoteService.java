package app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entities.Category;
import app.entities.Note;
import app.repository.ICategoryRepository;
import app.repository.INoteRepository;

@Service
public class NoteService implements INoteService {
	
	@Autowired
	private INoteRepository noteRepo;

	@Override
	public List<Note> findAll() {
		return noteRepo.findAll();
	}

	@Override
	public Optional<Note> findById(Long id) {
		return noteRepo.findById(id);
	}

	@Override
	public Note save(Note note) {
		return noteRepo.save(note);
	}

	@Override
	public void deleteById(Long id) {
		noteRepo.deleteById(id);

	}

	@Override
	public Optional<Note> findByCategory(String category) {
	    List<Note> notesWithCategory = new ArrayList<>();
	    for (Note note : noteRepo.findAll()) {
	        for (Category noteCategory : note.getCategories()) {
	            if (noteCategory.getName().equals(category)) {
	                notesWithCategory.add(note);
	                break;
	            }
	        }
	    }

	    if (!notesWithCategory.isEmpty()) {
	        return Optional.of(notesWithCategory.get(0));
	    } else {
	        return Optional.empty();
	    }
	}



	@Override
	public void addCategory(Note note, Category cateogry) {
		Set<Category> categories = note.getCategories();
		categories.add(cateogry);
		note.setCategories(categories);
		noteRepo.save(note);

	}

	@Override
	public Set<Category> listCategories(Note note) {
		Set<Category> categories = note.getCategories();
		return categories;
	}

	@Override
	public List<Note> findByArchivedTrue() {
		return noteRepo.findByArchivedTrue();
	}

	@Override
	public List<Note> findByArchivedFalse() {
		return noteRepo.findByArchivedFalse();
	}
	
    @Override
    public List<Note> findByCategoryId(Long categoryId) {
        return noteRepo.findByCategoryId(categoryId);
    }

}