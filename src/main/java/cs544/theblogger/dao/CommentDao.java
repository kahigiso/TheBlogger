package cs544.theblogger.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cs544.theblogger.entity.Comment;
import cs544.theblogger.idao.IComment;


@Service
public class CommentDao implements IComment{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Comment create(Comment comment) {
		return (Comment) sessionFactory.getCurrentSession().merge(comment);
	}

	@Override
	public void update(Comment comment) {
		sessionFactory.getCurrentSession().update(comment);
	}

	@Override
	public Comment get(Long id) {
		return (Comment) sessionFactory.getCurrentSession().get(Comment.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Comment> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Comment.class).list();
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
