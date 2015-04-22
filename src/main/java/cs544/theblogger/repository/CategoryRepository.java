package cs544.theblogger.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import cs544.theblogger.entity.Category;


public interface CategoryRepository extends JpaRepository<Category, Long>{
}
