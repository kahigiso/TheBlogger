package cs544.theblogger.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cs544.theblogger.entity.User;
import cs544.theblogger.service.RoleService;
import cs544.theblogger.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	private RoleService roleService;
	@Autowired
	private UserService userService;
	
	@ModelAttribute("user")
	public User construct(){
		return new User();
	}
	
	@RequestMapping("/login")
	public String login(){
		return "login";
	}
	
	@RequestMapping(value="/login/register")
	public String showRegister(){
		return "register";
	}
	
	@RequestMapping(value="/login/register", method=RequestMethod.POST)
	public String doRegister(@ModelAttribute("user") User user){
		user.addRoles(roleService.findByName("CONTRIBUTOR"));
		userService.create(user);
		return "register";
	}
}
