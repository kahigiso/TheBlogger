package cs544.theblogger.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Category;
import cs544.theblogger.repository.CategoryRepository;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	private static final Logger log = Logger.getLogger(CategoryService.class.getName());
	

	public Category create(Category category) {
		return categoryRepository.save(category);
	}

	public List<Category> getAll() {
		return  categoryRepository.findAll();
	}
	
	public void delete(long id) {
		categoryRepository.delete(id);
	}
	
	public void getCategory(Category category) {
		categoryRepository.delete(category);
	}

	public Category find(long id) {
		return categoryRepository.findOne(id);
	}

}
