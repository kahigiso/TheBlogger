package cs544.theblogger.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cs544.theblogger.entity.Article;
import cs544.theblogger.repository.ArticleRepository;


@Service
@Transactional(propagation=Propagation.REQUIRED)
public class ArticleService {
	
	private static final int PAGE_SIZE = 5;
	private static final Logger log = Logger.getLogger(ArticleService.class.getName());
	
	@Autowired
	private ArticleRepository articleRepository;

	public Article create(Article article) {
		return articleRepository.save(article);
	}

	public Page<Article> getAll(Integer pageNumber) {
		log.info("loading pages");
		PageRequest pageRequest = new PageRequest(pageNumber - 1, PAGE_SIZE, Sort.Direction.DESC, "createdDate");
		log.info("loaded pages"+pageNumber.toString());
		return  articleRepository.findAll(pageRequest);
	}
	
	public List<Article> getAll(){
		return articleRepository.findAll();
	}

	public Article find(long id) {
		return articleRepository.findOne(id);
	}

}
