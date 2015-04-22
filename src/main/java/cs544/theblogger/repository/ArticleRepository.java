package cs544.theblogger.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import cs544.theblogger.entity.Article;
import cs544.theblogger.entity.Category;

public interface ArticleRepository extends JpaRepository<Article, Long>{
	
	Page<Article> findByCategoryAndDraftFalse(Category category, Pageable pageable);
	Page<Article> findByDraftFalse(Pageable pageRequest);
}
