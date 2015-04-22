package cs544.theblogger.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;

import cs544.theblogger.entity.Comment;


@Controller
public class CommentController {
	
	@ModelAttribute("comment")
	public Comment construct(){
		return new Comment();
	}
	
	
	

}
