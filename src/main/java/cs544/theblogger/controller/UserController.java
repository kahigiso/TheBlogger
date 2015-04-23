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
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping(value="/administrate/users")
	public String listAll(Model model){
		model.addAttribute("users", userService.getAll());
		return "users";
	}
	
	@RequestMapping(value="/administrate/users/details/{id}", method=RequestMethod.GET)
	public String details(@PathVariable long id, Model model){
		model.addAttribute("user", userService.find(id));
		return "user-details";
	}
	
	@RequestMapping(value="/administrate/users/add", method=RequestMethod.GET)
	public String showAdd(){
		return "addUser";
	}
	
	@RequestMapping(value="/administrate/users/edit/{id}", method=RequestMethod.GET)
	public String edit(@PathVariable long id, Model model){
		model.addAttribute("user", userService.find(id));
		model.addAttribute("roles", roleService.findAll());
		return "addUser";
	}
	
	@RequestMapping(value="/administrate/users/add", method=RequestMethod.POST)
	public String doAdd(@Valid User user,BindingResult result, Model model){
		String view = "redirect:/administrate/users";
		if(!result.hasErrors()){
			userService.create(user);
			model.addAttribute("SUCCESS_MESSAGE", "User create successfully !");
		}else view ="addUser";
		return view;
	}	

}
