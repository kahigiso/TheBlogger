package cs544.theblogger.idao;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Article;

@Transactional(propagation=Propagation.MANDATORY)
public interface IArticle {
	public  Article create(Article article);
    public  void update(Article article);
    public  Article get(Long id);
    public  List<Article> getAll();
    public  void delete(Long id);

}
