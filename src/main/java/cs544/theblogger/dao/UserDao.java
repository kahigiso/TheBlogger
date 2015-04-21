/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs544.theblogger.dao;

import cs544.theblogger.entity.User;
import cs544.theblogger.idao.IUserDao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeankahigiso
 */
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class UserDao implements IUserDao{
    
	@Autowired
    SessionFactory sessionFactory;

    @Override
    public User create(User user) {
       return (User) sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void update(User user) {
       sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User get(Long userId) {
       return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

	@Override
	@SuppressWarnings("unchecked")
    public List<User> getAll() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(id);
	}
    
}
