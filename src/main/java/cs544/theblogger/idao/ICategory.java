package cs544.theblogger.idao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Category;

@Transactional(propagation=Propagation.MANDATORY)
public interface ICategory {
	public  Category create(Category category);
    public  void update(Category category);
    public  Category get(Long id);
    public  List<Category> getAll();
    public  void delete(Long id);
}
