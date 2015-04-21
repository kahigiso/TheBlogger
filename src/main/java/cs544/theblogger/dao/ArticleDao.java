package cs544.theblogger.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Article;
import cs544.theblogger.idao.IArticle;

@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ArticleDao implements IArticle{
	
	@Autowired
	SessionFactory sessionFactory;

	@Override
	public Article create(Article article) {
		return (Article) sessionFactory.getCurrentSession().merge(article);
	}

	@Override
	public void update(Article article) {
		sessionFactory.getCurrentSession().update(article);
		
	}

	@Override
	public Article get(Long id) {
		return (Article) sessionFactory.getCurrentSession().get(Article.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Article> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Article.class).list();
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}

}
