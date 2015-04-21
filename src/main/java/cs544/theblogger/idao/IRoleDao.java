package cs544.theblogger.idao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Role;

@Transactional(propagation=Propagation.MANDATORY)
public interface IRoleDao {
	public  Role create(Role role);
	public  void update(Role role);
	public  Role get(Long id);
	public  List<Role> getAll();
	public  void delete(Long id);

}
