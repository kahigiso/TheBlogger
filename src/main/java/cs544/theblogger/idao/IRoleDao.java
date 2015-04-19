package cs544.theblogger.idao;

import java.util.List;

import cs544.theblogger.entity.Role;

public interface IRoleDao {
	public abstract Role createRole(Role role);
	public abstract void updateRole(Role role);
	public abstract Role loadRole(Long roleId);
	public abstract List<Role> getRoles(Long roleId);

}
