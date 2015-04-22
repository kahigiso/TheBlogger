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

import cs544.theblogger.entity.User;
import cs544.theblogger.service.RoleService;
import cs544.theblogger.service.UserService;


@Controller
@RequestMapping(value="/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	public String listAll(Model model){
		model.addAttribute("users", userService.getAll());
		return "users";
	}
	
	@RequestMapping(value="/users/details/{id}", method=RequestMethod.GET)
	public String details(@PathVariable long id, Model model){
		model.addAttribute("user", userService.find(id));
		return "user-details";
	}
	
	@RequestMapping(value="/users/add")
	public String showAdd(){
		return "addUser";
	}
	
	@RequestMapping(value="/users/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("user", userService.find(id));
		return "addUser";
	}
	
	@RequestMapping(value="/users/add", method=RequestMethod.POST)
	public String add(@Valid User user,BindingResult result, Model model){
		String view = "redirect:/users";
		if(!result.hasErrors()){
			userService.create(user);
			//TODO add success message
		}else view ="addUser";
		return view;
	}	

}
