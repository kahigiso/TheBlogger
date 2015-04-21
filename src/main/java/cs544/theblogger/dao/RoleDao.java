package cs544.theblogger.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Role;
import cs544.theblogger.idao.IRoleDao;


/**
*
* @author jeankahigiso
*/
@Transactional(propagation = Propagation.REQUIRED)
@Service
public class RoleDao implements IRoleDao{

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public Role create(Role role) {
		return (Role) sessionFactory.getCurrentSession().merge(role);
	}

	@Override
	public void update(Role role) {
		sessionFactory.getCurrentSession().update(role);
	}

	@Override
	public Role get(Long id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getAll() {
		return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	}

	@Override
	public void delete(Long id) {
		sessionFactory.getCurrentSession().delete(id);
		
	}	
}
