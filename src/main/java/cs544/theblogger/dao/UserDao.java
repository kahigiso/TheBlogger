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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jeankahigiso
 */
@Transactional(propagation = Propagation.MANDATORY)
public class UserDao implements IUserDao{
    
    SessionFactory sessionFactory;

    @Override
    public User createUser(User user) {
       return (User) sessionFactory.getCurrentSession().merge(user);
    }

    @Override
    public void updateUser(User user) {
       sessionFactory.getCurrentSession().update(user);
    }

    @Override
    public User loadUser(Long userId) {
       return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<User> getUsers(Long userId) {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }
    
}
