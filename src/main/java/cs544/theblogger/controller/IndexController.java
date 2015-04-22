package cs544.theblogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cs544.theblogger.entity.Article;
import cs544.theblogger.service.ArticleService;



@Controller
public class IndexController {
	
	@Autowired
	private ArticleService articleService;

	@RequestMapping(value="/index")
	public String home(Model model){
		model.addAttribute("articles", articleService.getAll());
		return "index";
	}
	
	//http://springinpractice.com/2012/06/30/pageable-custom-queries-with-spring-data-jpa
	@RequestMapping(value="/index/{pageNumber}")
	public String home(@PathVariable Integer pageNumber, Model model){
		
		Page<Article> page = articleService.getAll(pageNumber);

	    int current = page.getNumber() + 1;
	    int begin = Math.max(1, current - 5);
	    int end = Math.min(begin + 10, page.getTotalPages());
	    model.addAttribute("deploymentLog", page);
	    model.addAttribute("beginIndex", begin);
	    model.addAttribute("endIndex", end);
	    model.addAttribute("currentIndex", current);
//		model.addAttribute("ok", "text");
//		model.addAttribute("articles", articleService.getAll());
		return "index";
	}

}
