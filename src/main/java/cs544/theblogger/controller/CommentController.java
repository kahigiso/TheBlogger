package cs544.theblogger.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import cs544.theblogger.entity.Article;
import cs544.theblogger.entity.Comment;
import cs544.theblogger.service.ArticleService;
import cs544.theblogger.service.CommentService;


@Controller
@RequestMapping(value="/manage/comments")
public class CommentController {
	
	@Autowired
	private CommentService commentService;
	@Autowired
	private ArticleService articleService;
	
	@ModelAttribute("comment")
	public Comment construct(){
		return new Comment();
	}
	
	@RequestMapping(value= "", method=RequestMethod.GET)
	public String getComments(Model model, @RequestParam("p") Integer p){
		 Page<Comment> page = commentService.getAll(p);
		 int current = page.getNumber() + 1;
		 int begin = Math.max(1, current - 5);
		 int end = Math.min(begin + 10, page.getTotalPages());
		 model.addAttribute("pages", page);
		 model.addAttribute("beginIndex", begin);
		 model.addAttribute("endIndex", end);
		 model.addAttribute("currentIndex", current);
		return "comments";
	}
	
	@RequestMapping(value="/delete/{id}", method=RequestMethod.GET)
	public String delete(@PathVariable long id,HttpServletRequest request, Model model,RedirectAttributes redirectAttributes){
		if(commentService.find(id)!=null){
			commentService.delete(id);
			redirectAttributes.addFlashAttribute("SUCCESS_MESSAGE", "Comment deteted successfully!");
		}else{
			redirectAttributes.addFlashAttribute("FAILED_MESSAGE", "Comment could not be deteted!");
		}
		return "redirect:"+request.getHeader("Referer");
	}
	
	@RequestMapping(value= "/add", method=RequestMethod.GET)
	public String showAdd(@ModelAttribute("comment") Comment comment,@RequestParam("article") Long article, @RequestParam("parent") Long parent, Model model){
		comment.setArticle(articleService.find(article));
		comment.setParent(commentService.find(parent));
		return "addComment";
	}
	
	@RequestMapping(value= "/add/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("comment", commentService.find(id));
		return "addComment";
	}
	
	@RequestMapping(value= "/add", method=RequestMethod.POST)
	public String add(@Valid Comment comment, BindingResult result, Model model){
		String view = "redirect:/manage/comments/add";
		if(result.hasErrors())
			commentService.create(comment);
		else view = "addComment";
		//TODO add success message
		return view;
	}
	

}
