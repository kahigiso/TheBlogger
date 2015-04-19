package cs544.theblogger.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Role;
import cs544.theblogger.idao.IRoleDao;


/**
*
* @author jeankahigiso
*/
@Transactional(propagation = Propagation.MANDATORY)
public class RoleDao implements IRoleDao{

	
	SessionFactory sessionFactory;
	
	@Override
	public Role createRole(Role role) {
		return (Role) sessionFactory.getCurrentSession().merge(role);
	}

	@Override
	public void updateRole(Role role) {
		sessionFactory.getCurrentSession().update(role);
	}

	@Override
	public Role loadRole(Long id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Role> getRoles(Long id) {
		
		return sessionFactory.getCurrentSession().createCriteria(Role.class).list();
	}

	@Override
	public void deleteRole(Long id) {
		sessionFactory.getCurrentSession().delete(id);
		
	}	
}
