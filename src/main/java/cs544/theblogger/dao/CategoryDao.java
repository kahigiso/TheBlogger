package cs544.theblogger.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Category;
import cs544.theblogger.idao.ICategory;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class CategoryDao implements ICategory{
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public Category create(Category category) {
		return (Category) sessionFactory.getCurrentSession().merge(category);
	}

	@Override
	public void update(Category category) {
		sessionFactory.getCurrentSession().update(category);
	}

	@Override
	public Category get(Long id) {
		return (Category) sessionFactory.getCurrentSession().get(Category.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Category> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Category.class).list();
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
