package cs544.theblogger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.theblogger.entity.Article;
import cs544.theblogger.service.ArticleService;


@Controller
public class ArticleController {
	
	@Autowired
	private ArticleService articleService;
	
	@ModelAttribute("article")
	public Article contruct(){
		return new Article();
	}
	
	@RequestMapping(value="/articles", method=RequestMethod.GET)
	public String getArticles(Model model){
		model.addAttribute("articles", articleService.getAll());
		return "articles";
	}
	
	@RequestMapping(value ="/articles/add", method=RequestMethod.GET)
	public String showAdd(){
		return "addArticle";
	}
	
	@RequestMapping(value="/articles/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("article", articleService.find(id));
		return "addArticle";
	}
	
	@RequestMapping(value="/articles/add", method = RequestMethod.POST)
	public String doAdd(@Valid Article article, Model model, BindingResult result){
		String view = "redirect:/articles/add";
		if(!result.hasErrors())
			articleService.create(article);
		else view = "addArticles";
		return view;
	}

}
