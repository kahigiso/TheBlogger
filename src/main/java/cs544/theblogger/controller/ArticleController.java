package cs544.theblogger.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs544.theblogger.entity.Article;
import cs544.theblogger.service.ArticleService;
import cs544.theblogger.service.CategoryService;
import cs544.theblogger.service.NoSuchResourceException;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategoryService categoryService;
	
	@ModelAttribute("article")
	public Article contruct(){
		return new Article();
	}
	
	@RequestMapping(value="/manage/articles", method=RequestMethod.GET)
	public String getArticles(Model model, @RequestParam("p") Integer p){
		 Page<Article> page = articleService.getAll(p);
		 int current = page.getNumber() + 1;
		 int begin = Math.max(1, current - 5);
		 int end = Math.min(begin + 10, page.getTotalPages());
		 model.addAttribute("pages", page);
		 model.addAttribute("beginIndex", begin);
		 model.addAttribute("endIndex", end);
		 model.addAttribute("currentIndex", current);
		return "articles";
	}
	

	
	@RequestMapping(value="/manage/articles/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable long id,HttpServletRequest request, Model model,RedirectAttributes redirectAttributes){
		if(articleService.find(id)!=null){
			articleService.delete(id);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", "Article deteted successfully!");
		}else{
			redirectAttributes.addFlashAttribute("FAILED_MESSAGE", "Article could not be deteted!");
		}
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value="/manage/articles/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("article", articleService.find(id));
		model.addAttribute("categories",categoryService.getAll());
		return "addArticle";
	}
	
	@RequestMapping(value ="/manage/articles/addArticle",  method = RequestMethod.GET)
	public String showAdd(@ModelAttribute("article") Article article, Model model){
		model.addAttribute("categories",categoryService.getAll());
		return "addArticle";
	}
	
	@RequestMapping(value="/manage/articles/addArticle", method = RequestMethod.POST)
	public String doAdd(@Valid @ModelAttribute("article") Article article, Model model, BindingResult result){
		model.addAttribute("categories",categoryService.getAll());
		if(!result.hasErrors()) return "redirect:/articles/add";
		articleService.create(article);
		model.addAttribute("SUCCESS_MESSAGE", "Article was added successfully!");	
		return "articles";
	}
	
	@ExceptionHandler(value=NoSuchResourceException.class)
	public String handle(Exception e,Model m) {
		m.addAttribute("clazz", Article.class.getName());
		m.addAttribute("exception", e);
		return "noSuchResource";
	}

}
