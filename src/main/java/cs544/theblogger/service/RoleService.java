package cs544.theblogger.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Role;
import cs544.theblogger.repository.RoleRepository;


/**
*
* @author jeankahigiso
*/
@Service
@Transactional(propagation = Propagation.REQUIRED)
public class RoleService{

	@Autowired
	private RoleRepository roleRepository;
	private static final Logger log = Logger.getLogger(RoleService.class.getName());

	public Role create(Role role) {
		return roleRepository.save(role);
	}

	public Role findByName(String string) {
		return roleRepository.findByName(string);
	}

	public List<Role> findAll() {
		return roleRepository.findAll();
	}

	public Role find(long id) {
		return roleRepository.findOne(id);
	}	
	
}
