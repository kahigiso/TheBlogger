package cs544.theblogger.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import cs544.theblogger.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String string);

}
