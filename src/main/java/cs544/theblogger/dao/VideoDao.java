package cs544.theblogger.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Video;
import cs544.theblogger.idao.IVideo;

@Service
@Transactional(propagation= Propagation.REQUIRED)
public class VideoDao implements IVideo{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Video create(Video video) {
		return (Video) sessionFactory.getCurrentSession().merge(video);
	}

	@Override
	public void update(Video video) {
		sessionFactory.getCurrentSession().update(video);
		
	}

	@Override
	public Video get(Long id) {
		return (Video) sessionFactory.getCurrentSession().get(Video.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Video> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Video.class).list();
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
