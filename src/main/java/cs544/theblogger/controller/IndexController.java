package cs544.theblogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cs544.theblogger.entity.Article;
import cs544.theblogger.entity.Category;
import cs544.theblogger.service.ArticleService;
import cs544.theblogger.service.CategoryService;



@Controller
@RequestMapping(value="/index")
public class IndexController {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="")
	public String home(Model model){
		 Page<Article> page = articleService.getByDraftFalse(1);
		 
		 int current = page.getNumber() + 1;
		 int begin = Math.max(1, current - 5);
		 int end = Math.min(begin + 10, page.getTotalPages());
		 model.addAttribute("pages", page);
		 model.addAttribute("categories", categoryService.getAll());
		 model.addAttribute("category", null);
		 model.addAttribute("beginIndex", begin);
		 model.addAttribute("endIndex", end);
		 model.addAttribute("currentIndex", current);
		return "index";
	}
	
	@RequestMapping(value="/pages/{cat}", method=RequestMethod.GET)
	public String homePage(@PathVariable Long cat, @RequestParam("p") Integer p, Model model){
		 model.addAttribute("categories", categoryService.getAll());
		 Category category = categoryService.find(cat);
		 Page<Article> page = null;
		 
		 if(category == null) page = articleService.getByDraftFalse(p);
		 else page = articleService.getPageByCategoryAndDraftFalse(category,p);	
		 
		 int current = page.getNumber() + 1;
		 int begin = Math.max(1, current - 5);
		 int end = Math.min(begin + 10, page.getTotalPages());
		 model.addAttribute("pages", page);
		 model.addAttribute("categories", categoryService.getAll());
		 model.addAttribute("category", category);
		 model.addAttribute("beginIndex", begin);
		 model.addAttribute("endIndex", end);
		 model.addAttribute("currentIndex", current);
		 return "index";
	}
	
	

}
