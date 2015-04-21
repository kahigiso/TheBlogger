package cs544.theblogger.dao;

import java.util.List;





import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Picture;
import cs544.theblogger.idao.IPicture;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class PictureDao implements IPicture{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Picture create(Picture picture) {
		return (Picture) sessionFactory.getCurrentSession().merge(picture);
	}

	@Override
	public void update(Picture picture) {
		sessionFactory.getCurrentSession().update(picture);
	}

	@Override
	public Picture get(Long id) {
		return (Picture) sessionFactory.getCurrentSession().get(Picture.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Picture> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Picture.class).list();
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}
}
