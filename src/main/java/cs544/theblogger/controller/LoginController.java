package cs544.theblogger.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	
	@RequestMapping(value="/register/register")
	public String showRegister(){
		return "register";
	}
	
	@RequestMapping(value="/register/register", method=RequestMethod.POST)
	public String doRegister(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
		if(result.hasErrors()){
			model.addAttribute("FAILED_MESSAGE", "Please the highlighted field(s) is/are incorect!");
			return "register";
		}	
		user.addRoles(roleService.findByName("ROLE_USER"));
		userService.create(user);	
		model.addAttribute("FAILED_MESSAGE", "Please the highlighted field are incorect!");
		return "redirect:index";
	}
}
