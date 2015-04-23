package cs544.theblogger.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Role;

@Transactional(propagation=Propagation.MANDATORY)
public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByName(String string);

}
